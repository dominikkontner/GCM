package com.k2.gcm.request;

/**
 * This parameter specifies the key-value pairs of the notification payload. See Notification payload support
 * for detail. For more information about notification message and data message options, see Payload.
 *
 * @author Dominik Kontner
 * @since 1.0
 */
public class Notification {

  /**
   * Indicates notification title. This field is not visible on iOS phones and tablets.
   */
  private String title;
  /**
   * Indicates notification body text.
   */
  private String body;
  /**
   * Indicates notification icon. On Android: sets value to myicon for drawable resource myicon.png.
   */
  private String icon;

  /**
   * Indicates sound to be played. Supports only default currently.
   */
  private String sound;
  /**
   * Indicates whether each notification message results in a new entry on the notification center on Android. If not set, each request creates a new notification. If set, and a notification with the same tag is already being shown, the new notification replaces the existing one in notification center.
   */
  private String tag;

  /**
   * Indicates color of the icon, expressed in #rrggbb format
   */
  private String color;

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
   */
  private String click_action;


  public Notification() {
  }

  /**
   * @param title Notification Title
   * @param body Notification Body
   * @param icon Notification icon
   */
  public Notification(String title, String body, String icon) {
    this.title = title;
    this.body = body;
    this.icon = icon;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getSound() {
    return sound;
  }

  public void setSound(String sound) {
    this.sound = sound;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getClick_action() {
    return click_action;
  }

  public void setClick_action(String click_action) {
    this.click_action = click_action;
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
      ", click_action='" + click_action + '\'' +
      '}';
  }
}
