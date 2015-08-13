package com.k2.gcm.response;

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
  private String multicast_id;

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
  private int canonical_ids;

  /**
   * Array of objects representing the status of the messages processed.
   * The objects are listed in the same order as the request (i.e., for each registration ID in the request,
   * its result is listed in the same index in the response).
   */
  private List<Result> results;

  public String getMulticast_id() {
    return multicast_id;
  }

  public void setMulticast_id(String multicast_id) {
    this.multicast_id = multicast_id;
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

  public int getCanonical_ids() {
    return canonical_ids;
  }

  public void setCanonical_ids(int canonical_ids) {
    this.canonical_ids = canonical_ids;
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
      "multicast_id='" + multicast_id + '\'' +
      ", success=" + success +
      ", failure=" + failure +
      ", canonical_ids=" + canonical_ids +
      ", results=" + results +
      '}';
  }

}
