package com.k2.gcm.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Result of a GCM message request that returned HTTP status code 200.
 * <p/>
 * An object representing the status of the messages processed. The objects are listed
 * in the same order as the request (i.e., for each registration ID in the request, its result is listed
 * in the same index in the response).
 * <p/>
 * message_id: String specifying a unique ID for each successfully processed message.
 * registration_id: Optional string specifying the canonical registration token for the client app that
 * the message was processed and sent to. Sender should use this value as the registration token for future requests.
 * Otherwise, the messages might be rejected.
 * <p/>
 * error: String specifying the error that occurred when processing the message for the recipient.
 * The possible values can be found in table 11.
 *
 * @author Dominik Kontner
 * @see <a href="https://developers.google.com/cloud-messaging/server-ref">GCM Server Reference</a>
 * @since 1.0
 */
public class Result {

  @JsonProperty("message_id")
  private String messageId;
  @JsonProperty("registration_id")
  private String registrationId;
  private String error;

  public Result() {
  }

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public String getRegistrationId() {
    return registrationId;
  }

  public void setRegistrationId(String registrationId) {
    this.registrationId = registrationId;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  @Override
  public String toString() {
    return "Result{" +
      "message_id='" + messageId + '\'' +
      ", registration_id='" + registrationId + '\'' +
      ", error='" + error + '\'' +
      '}';
  }
}
