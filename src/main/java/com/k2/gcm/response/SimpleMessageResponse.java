package com.k2.gcm.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.k2.gcm.request.Result;

import java.util.List;

/**
 * @author Dominik Kontner
 * @since 1.0
 */
public class SimpleMessageResponse {

  /**
   * Unique ID(number)identifying the multicast message
   */
  @JsonProperty("multicast_id")
  private String multicastId;

  /**
   * Number of messages that were processed without an error.
   */
  private int success;

  /**
   * number	Number of messages that could not be processed.
   */
  private int failure;

  /**
   * Number of results that contain a canonical registration token. See the registration overview
   * for more discussion of this topic.
   */
  @JsonProperty("canonical_ids")
  private int canonicalIds;

  /**
   * Array of objects representing the status of the messages processed.
   * The objects are listed in the same order as the request (i.e., for each registration ID in the request,
   * its result is listed in the same index in the response).
   */
  private List<Result> results;

  public String getMulticastId() {
    return multicastId;
  }

  public void setMulticastId(String multicastId) {
    this.multicastId = multicastId;
  }

  public int getSuccess() {
    return success;
  }

  public void setSuccess(int success) {
    this.success = success;
  }

  public int getFailure() {
    return failure;
  }

  public void setFailure(int failure) {
    this.failure = failure;
  }

  public int getCanonicalIds() {
    return canonicalIds;
  }

  public void setCanonicalIds(int canonicalIds) {
    this.canonicalIds = canonicalIds;
  }

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
