package com.k2.gcm.request;

/**
 * @author Dominik Kontner
 * @since 1.0
 */
public class MulticastMessage extends AMessage{

  /**
   * This parameter specifies a list of devices (registration tokens, or IDs) receiving a multicast message.
   * It must contain at least 1 and at most 1000 registration IDs.
   * <p/>
   * Multicast messages (sending to more than 1 registration IDs) are allowed using HTTP JSON format only.
   */
  private String[] registration_ids;

}
