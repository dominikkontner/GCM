package com.k2.gcm.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * @author Dominik Kontner
 * @since 1.0
 */
public class MulticastMessage extends AMessage {


  @JsonProperty("registration_ids")
  private String[] registrationIds;

  public String[] getRegistrationIds() {
    return registrationIds;
  }

  /**
   * This parameter specifies a list of devices (registration tokens, or IDs) receiving a multicast message.
   * It must contain at least 1 and at most 1000 registration IDs.
   * <p/>
   * Multicast messages (sending to more than 1 registration IDs) are allowed using HTTP JSON format only.
   *
   * @param registrationIds
   */
  public void setRegistrationIds(String[] registrationIds) {
    this.registrationIds = registrationIds;
  }

  @Override
  public String toString() {
    return "MulticastMessage{" +
      "registrationIds=" + Arrays.toString(registrationIds) +
      '}';
  }
}
