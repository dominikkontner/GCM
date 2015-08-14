package com.k2.gcm.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dominik Kontner
 * @since 1.0
 */
public class TopicMessageResponse {

  @JsonProperty("message_id")
  private String messageId;
  private String error;


  /**
   * The topic message ID when GCM has successfully received the request and will attempt to deliver to all subscribed devices.
   */
  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  /**
   * Error that occurred when processing the message. The possible values can be found in table 11.
   */
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }


  @Override
  public String toString() {
    return "TopicMessageResponse{" +
      "messageId='" + messageId + '\'' +
      ", error='" + error + '\'' +
      '}';
  }
}
