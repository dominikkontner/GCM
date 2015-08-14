package com.k2.gcm.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.k2.gcm.request.Result;

import java.util.List;

/**
 * @author Dominik Kontner
 * @since 1.0
 */
public class SimpleMessageResponse {


  @JsonProperty("multicast_id")
  private String multicastId;

  private int success;
  private int failure;

  @JsonProperty("canonical_ids")
  private int canonicalIds;

  private List<Result> results;

  /**
   * Unique ID(number)identifying the multicast message
   */
  public String getMulticastId() {
    return multicastId;
  }

  public void setMulticastId(String multicastId) {
    this.multicastId = multicastId;
  }

  /**
   * Number of messages that were processed without an error.
   */
  public int getSuccess() {
    return success;
  }

  public void setSuccess(int success) {
    this.success = success;
  }

  /**
   * number	Number of messages that could not be processed.
   */
  public int getFailure() {
    return failure;
  }

  public void setFailure(int failure) {
    this.failure = failure;
  }

  /**
   * Number of results that contain a canonical registration token. See the registration overview
   * for more discussion of this topic.
   */
  public int getCanonicalIds() {
    return canonicalIds;
  }

  public void setCanonicalIds(int canonicalIds) {
    this.canonicalIds = canonicalIds;
  }

  /**
   * Array of objects representing the status of the messages processed.
   * The objects are listed in the same order as the request (i.e., for each registration ID in the request,
   * its result is listed in the same index in the response).
   */

  public List<Result> getResults() {
    return results;
  }

  public void setResults(List<Result> results) {
    this.results = results;
  }


  @Override
  public String toString() {
    return "DownstreamMessageResponse{" +
      "multicast_id='" + multicastId + '\'' +
      ", success=" + success +
      ", failure=" + failure +
      ", canonical_ids=" + canonicalIds +
      ", results=" + results +
      '}';
  }

}
