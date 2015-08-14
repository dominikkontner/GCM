package com.k2.gcm.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This parameter specifies the key-value pairs of the notification payload. See Notification payload support
 * for detail. For more information about notification message and data message options, see Payload.
 *
 * @author Dominik Kontner
 * @since 1.0
 */
public class Notification {


  private String title;
  private String body;
  private String icon;
  private String sound;
  private String tag;
  private String color;

  @JsonProperty("click_action")
  private String clickAction;


  public Notification() {
  }

  /**
   * @param title Notification Title
   * @param body  Notification Body
   * @param icon  Notification icon
   */
  public Notification(String title, String body, String icon) {
    this.title = title;
    this.body = body;
    this.icon = icon;
  }

  public String getTitle() {
    return title;
  }

  /**
   * Indicates notification title. This field is not visible on iOS phones and tablets.
   *
   * @param title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  /**
   * Indicates notification body text.
   *
   * @param body
   */
  public void setBody(String body) {
    this.body = body;
  }

  public String getIcon() {
    return icon;
  }

  /**
   * Indicates notification icon. On Android: sets value to myicon for drawable resource myicon.png.
   *
   * @param icon
   */
  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getSound() {
    return sound;
  }

  /**
   * Indicates sound to be played. Supports only default currently.
   *
   * @param sound
   */
  public void setSound(String sound) {
    this.sound = sound;
  }

  public String getTag() {
    return tag;
  }

  /**
   * Indicates whether each notification message results in a new entry on the notification center on Android. If not set, each request creates a new notification. If set, and a notification with the same tag is already being shown, the new notification replaces the existing one in notification center.
   *
   * @param tag
   */
  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getColor() {
    return color;
  }

  /**
   * Indicates color of the icon, expressed in #rrggbb format
   *
   * @param color
   */
  public void setColor(String color) {
    this.color = color;
  }

  public String getClickAction() {
    return clickAction;
  }

  /**
   * The action associated with a user click on the notification.
   * <p/>
   * On Android, if this is set, an activity with a matching intent filter is launched when user clicks the notification. For example, if one of your Activities includes the intent filter:
   * <p/>
   * <intent-filter>
   * <action android:name="OPEN_ACTIVITY_1" />
   * <category android:name="android.intent.category.DEFAULT" />
   * </intent-filter>
   * Set click_action to OPEN_ACTIVITY_1 to open it.
   * If set, corresponds to category in APNS payload.
   *
   * @param clickAction
   */
  public void setClickAction(String clickAction) {
    this.clickAction = clickAction;
  }

  @Override
  public String toString() {
    return "Notification{" +
      "title='" + title + '\'' +
      ", body='" + body + '\'' +
      ", icon='" + icon + '\'' +
      ", sound='" + sound + '\'' +
      ", tag='" + tag + '\'' +
      ", color='" + color + '\'' +
      ", click_action='" + clickAction + '\'' +
      '}';
  }
}
