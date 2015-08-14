package com.k2.gcm;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.k2.gcm.request.MulticastMessage;
import com.k2.gcm.request.SimpleMessage;
import com.k2.gcm.request.TopicMessage;
import com.k2.gcm.response.SimpleMessageResponse;
import com.k2.gcm.request.AMessage;
import com.k2.gcm.response.TopicMessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Random;

/**
 * Performs json calls to GCM backend
 *
 * @author Dominik Kontner
 */
public class Sender {

  private static final Logger log = LoggerFactory.getLogger(Sender.class);
  /**
   * jackson object mapper for (de-)serialization
   */
  private final static ObjectMapper objectMapper = new ObjectMapper();

  /**
   * Spring rest template for REST requests
   */
  private final RestTemplate restTemplate = new RestTemplate();

  //gcm
  private final static String GCM_URL = "https://gcm-http.googleapis.com/gcm/send";
  private final static String HEADER_AUTH = "Authorization";

  //config
  private final static int MAX_RETRIES = 3;
  private final static int BACKOFF_INITIAL_DELAY = 1000;
  private static final int MAX_BACKOFF_DELAY = 60 * 1000;

  /**
   * random source for exponential backoff algorithm
   */
  private final Random random = new Random();

  /**
   * gcm api key
   */
  private final String apiKey;


  /**
   * Creates a new GCM Sender instance bound to a specific GCM Api Key.
   *
   * @param apiKey GCM API key provides by google developer console project
   */
  public Sender(String apiKey) {
    this.apiKey = apiKey;
  }


  /**
   * sends a topic push message with no retry
   * <p/>
   * "to" field must have "/topics/" prefix i.e: "/topics/foobar"
   *
   * @param message Server Request
   * @return Server Response
   * @throws IOException if request fails
   */
  public TopicMessageResponse sendMessageNoRetry(TopicMessage message) throws IOException {
    return (TopicMessageResponse) sendMessageNoRetry(message, TopicMessageResponse.class);
  }


  /**
   * sends a push message with no retry to one recipient
   *
   * @param message Server Request
   * @return Server Response
   * @throws IOException if request fails
   */

  public SimpleMessageResponse sendMessageNoRetry(SimpleMessage message) throws IOException {
    return (SimpleMessageResponse) sendMessageNoRetry(message, SimpleMessageResponse.class);
  }


  /**
   * sends a push message with no retry to 1-1000 recipients
   *
   * @param message Server Request
   * @return Server Response
   * @throws IOException if request fails
   */
  public SimpleMessageResponse sendMessageNoRetry(MulticastMessage message) throws IOException {
    return (SimpleMessageResponse) sendMessageNoRetry(message, SimpleMessageResponse.class);
  }

  /**
   * sends a topic push message with exponential backoff retry (3 times)
   * <p/>
   * "to" field must have "/topics/" prefix i.e: "/topics/foobar"
   *
   * @param message Server Request
   * @return Server Response
   * @throws IOException if all attempts are not successful
   */
  public TopicMessageResponse sendMessage(TopicMessage message) throws IOException {
    return (TopicMessageResponse) sendMessage(message, TopicMessageResponse.class);
  }


  /**
   * sends a push message to one recipient with exponential backoff retry (3 times)
   * <p/>
   * "to" field must have "/topics/" prefix i.e: "/topics/foobar"
   *
   * @param message Server Request
   * @return Server Response
   * @throws IOException if all attempts are not successful
   */
  public SimpleMessageResponse sendMessage(SimpleMessage message) throws IOException {
    return (SimpleMessageResponse) sendMessage(message, SimpleMessageResponse.class);
  }


  /**
   * sends a push message to 1-1000 recipients with exponential backoff retry (3 times)
   * <p/>
   * "to" field must have "/topics/" prefix i.e: "/topics/foobar"
   *
   * @param message Server Request
   * @return Server Response
   * @throws IOException if all attempts are not successful
   */
  public SimpleMessageResponse sendMessage(MulticastMessage message) throws IOException {
    return (SimpleMessageResponse) sendMessage(message, SimpleMessageResponse.class);
  }


  /**
   * Sends a message to gcm push service and returns the server result.
   * Does not retry if the request fails.
   *
   * @param request Message
   * @return Server Result
   * @throws java.io.IOException
   */
  private Object sendMessageNoRetry(AMessage request, Class clazz) throws IOException {
    String json = objectMapper.writeValueAsString(request);
    log.info("GCM REQUEST: " + json);

    HttpEntity<String> entity = new HttpEntity<String>(json, getHttpHeaders());
    log.info("GCM HEADERS: " + entity.getHeaders().toString());

    // send request and parse result
    ResponseEntity<String> gcmResponse = restTemplate.postForEntity(GCM_URL, entity, String.class);
    log.info("GCM RESPONSE" + gcmResponse.getBody());

    return objectMapper.readValue(gcmResponse.getBody(), clazz);
  }

  /**
   * Sends a message to gcm push service and returns the server result.
   * If the request fails it retrys three times with exponential backoff.
   *
   * @param request Message
   * @return Server Result
   * @throws java.io.IOException
   */
  private Object sendMessage(AMessage request, Class clazz) throws IOException {

    int attempt = 0;
    int backoff = BACKOFF_INITIAL_DELAY;
    boolean tryAgain;
    Object result;

    do {
      attempt++;
      result = sendMessageNoRetry(request, clazz);
      tryAgain = (result == null && attempt <= MAX_RETRIES);
      if (tryAgain) {
        backoff = exponentialBackoffSleep(backoff);
      }
    } while (tryAgain);

    //check if send message was successful
    if (result == null) {
      throw new IOException("Could not send message after " + attempt + " attempts");
    }

    return result;

  }

  /**
   * sleep with exponential backoff algorithmus
   *
   * @param backoff current backoff value
   * @return new backoff value
   */
  private int exponentialBackoffSleep(int backoff) {
    try {

      int sleepTime = backoff / 2 + random.nextInt(backoff);
      Thread.sleep(sleepTime);

      if (2 * backoff < MAX_BACKOFF_DELAY) {
        backoff *= 2;
      }

    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    return backoff;
  }

  /**
   * @return http headers for gcm request
   */
  private HttpHeaders getHttpHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set(HEADER_AUTH, "key=" + apiKey);
    return headers;
  }

}
