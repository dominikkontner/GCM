package com.k2.gcm.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 *
 * @author Dominik Kontner
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
abstract public class AMessage {

  private String to;
  private Notification notification;
  private Map<String, String> data;

  @JsonProperty("time_to_live")
  private long timeToLive;

  @JsonProperty("delay_while_idle")
  private boolean delayWhileIdle;

  @JsonProperty("collapse_key")
  private String collapseKey;

  private short priority;

  @JsonProperty("dry_run")
  private boolean dryRun;


  @JsonProperty("restricted_package_name")
  private String restrictedPackageName;


  public AMessage() {

  }

  public AMessage(String to, Map<String, String> data) {
    this.to = to;
    this.data = data;
  }

  public AMessage(String to, Notification notification) {
    this.to = to;
    this.notification = notification;
  }

  public AMessage(String to, Map<String, String> data, Notification notification) {
    this.to = to;
    this.data = data;
    this.notification = notification;
  }

  public AMessage(String to, Notification notification, Map<String, String> data, long timeToLive, boolean delayWhileIdle, String collapseKey) {
    this.to = to;
    this.notification = notification;
    this.data = data;
    this.timeToLive = timeToLive;
    this.delayWhileIdle = delayWhileIdle;
    this.collapseKey = collapseKey;
  }

  public String getTo() {
    return to;
  }

  /**
   * This parameter specifies the recipient of a message.
   * <p/>
   * The value must be a registration token or notification key.
   *
   * @param to registerId for single message; /topics/foobar for topic message
   */
  public void setTo(String to) {
    this.to = to;
  }

  public Map<String, String> getData() {
    return data;
  }

  /**
   * This parameter specifies the key-value pairs of the message's payload.
   * <p/>
   * For example, with data:{"score":"3x1"}:
   * <p/>
   * On Android, this would result in an intent extra named score with the string value 3x1.
   * <p/>
   * On iOS, if the message is sent via APNS, it represents the custom data fields. If it is sent via GCM connection server,
   * it would be represented as key value dictionary in AppDelegate application:didReceiveRemoteNotification:.
   * <p/>
   * The key should not be a reserved word ("from" or any word starting with "google" or "gcm"). Do not use any of the words
   * defined in this table (such as collapse_key).
   * <p/>
   * Values in string types are recommended. You have to convert values in objects or other non-string data types (e.g.,
   * integers or booleans) to string.
   *
   * @param data key value map
   */
  public void setData(Map<String, String> data) {
    this.data = data;
  }

  /**
   * convenience method for {@link #setData(java.util.Map)}
   * adds a single param to data map
   *
   * @param key
   * @param value
   */
  public void putData(String key, String value) {
    if (data == null) {
      data = new LinkedHashMap<>();
    }
    data.put(key, value);
  }

  public Notification getNotification() {
    return notification;
  }


  /**
   * This parameter specifies the key-value pairs of the notification payload. See Notification payload support for detail.
   * For more information about notification message and data message options, see Payload.
   *
   * @param notification
   */
  public void setNotification(Notification notification) {
    this.notification = notification;
  }

  public long getTimeToLive() {
    return timeToLive;
  }

  /**
   * This parameter specifies how long (in seconds) the message should be kept in GCM storage if the device is offline. The maximum time to live supported is 4 weeks.
   * <p/>
   * The default value is 4 weeks.
   *
   * @param timeToLive
   */
  public void setTimeToLive(long timeToLive) {
    this.timeToLive = timeToLive;
  }

  public boolean isDelayWhileIdle() {
    return delayWhileIdle;
  }

  /**
   * When this parameter is set to true, it indicates that the message should not be sent until the device becomes active.
   * The default value is false.
   *
   * @param delayWhileIdle
   */
  public void setDelayWhileIdle(boolean delayWhileIdle) {
    this.delayWhileIdle = delayWhileIdle;
  }

  public String getCollapseKey() {
    return collapseKey;
  }

  /**
   * This parameter identifies a group of messages (e.g., with collapse_key: "Updates Available") that can be collapsed,
   * so that only the last message gets sent when delivery can be resumed. This is intended to avoid sending too many
   * of the same messages when the device comes back online or becomes active (see delay_while_idle).
   * <p/>
   * Note that there is no guarantee of the order in which messages get sent.
   * <p/>
   * Note: A maximum of 4 different collapse keys is allowed at any given time. This means a GCM connection server can simultaneously store 4 different send-to-sync messages per client app. If you exceed this number, there is no guarantee which 4 collapse keys the GCM connection server will keep.
   *
   * @param collapseKey
   */
  public void setCollapseKey(String collapseKey) {
    this.collapseKey = collapseKey;
  }


  public short getPriority() {
    return priority;
  }

  /**
   * Sets the priority of the message. Use values between 0 - 10, where the higher value represents higher priority.
   *
   * @param priority
   */
  public void setPriority(short priority) {
    this.priority = priority;
  }

  public boolean isDryRun() {
    return dryRun;
  }

  /**
   * This parameter, when set to true, allows developers to test a request without actually sending a message.
   * <p/>
   * The default value is false.
   *
   * @param dryRun
   */
  public void setDryRun(boolean dryRun) {
    this.dryRun = dryRun;
  }

  public String getRestrictedPackageName() {
    return restrictedPackageName;
  }

  /**
   * This parameter specifies the package name of the application where the registration tokens must match in order to receive the message.
   *
   * @param restrictedPackageName
   */
  public void setRestrictedPackageName(String restrictedPackageName) {
    this.restrictedPackageName = restrictedPackageName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AMessage)) return false;

    AMessage that = (AMessage) o;

    if (delayWhileIdle != that.delayWhileIdle) return false;
    if (dryRun != that.dryRun) return false;
    if (priority != that.priority) return false;
    if (timeToLive != that.timeToLive) return false;
    if (collapseKey != null ? !collapseKey.equals(that.collapseKey) : that.collapseKey != null) return false;
    if (data != null ? !data.equals(that.data) : that.data != null) return false;
    if (notification != null ? !notification.equals(that.notification) : that.notification != null) return false;
    if (restrictedPackageName != null ? !restrictedPackageName.equals(that.restrictedPackageName) : that.restrictedPackageName != null)
      return false;
    if (to != null ? !to.equals(that.to) : that.to != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = to != null ? to.hashCode() : 0;
    result = 31 * result + (notification != null ? notification.hashCode() : 0);
    result = 31 * result + (data != null ? data.hashCode() : 0);
    result = 31 * result + (int) (timeToLive ^ (timeToLive >>> 32));
    result = 31 * result + (delayWhileIdle ? 1 : 0);
    result = 31 * result + (collapseKey != null ? collapseKey.hashCode() : 0);
    result = 31 * result + (int) priority;
    result = 31 * result + (dryRun ? 1 : 0);
    result = 31 * result + (restrictedPackageName != null ? restrictedPackageName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SimpleGcmRequest{" +
      "to='" + to + '\'' +
      ", notification=" + notification +
      ", data=" + data +
      ", time_to_live=" + timeToLive +
      ", delay_while_idle=" + delayWhileIdle +
      ", collapse_key='" + collapseKey + '\'' +
      ", priority=" + priority +
      ", dry_run=" + dryRun +
      ", restricted_package_name='" + restrictedPackageName + '\'' +
      '}';
  }

}