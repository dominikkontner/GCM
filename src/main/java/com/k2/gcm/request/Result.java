package com.k2.gcm.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Result of a GCM message request that returned HTTP status code 200.
 *
 * @author Dominik Kontner
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
