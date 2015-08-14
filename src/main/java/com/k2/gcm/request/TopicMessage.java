package com.k2.gcm.request;

/**
 * GCM topic messaging allows your app server to send a message to multiple devices that have opted in to a particular
 * topic. Based on the publish/subscribe model, topic messaging supports up to one million subscriptions per app.
 * The app server sends messages with payloads up to 2KB to the topic, and GCM handles the message routing and
 * delivers the message reliably to the right devices. For example, users of a weather forecasting app could opt
 * in to a "severe weather alerts" topic and receive notifications of storms threatening specified areas.
 * <p/>
 * Developers can choose any topic name that matches the regular expression, "/topics/[a-zA-Z0-9-_.~%]+".
 * You can configure when to subscribe, when to send messages, and how to handle the notification when it reaches
 * the client app.
 *
 * @author Dominik Kontner
 * @see <a href="https://developers.google.com/cloud-messaging/topic-messaging">GCM Topic Message</a>
 * @since 1.0
 */
public class TopicMessage extends AMessage {

}
