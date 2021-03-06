# GCM

Library for sending GCM push messages. Currently UNSTABLE - API will change until version 1.0.0.

I decided to write this lib from scratch because https://github.com/google/gcm doesn't seem very maintainable.

This library uses GCMs JSON interface only (no plain http or XAMPP support).

## Supports

* Single Push Message
* Topic Message
* Multicast
* exponential backoff retry mechanism


## create jar file

```
./gradlew jar
```
or
```
./gradlew fatjar
```

## dependencies

* compile("org.springframework:spring-web:4.2.0.RELEASE")
* compile("com.fasterxml.jackson.core:jackson-databind:2.6.1")
* compile('org.slf4j:slf4j-simple:1.6.1')


## Usage

Send a simple push message to one client and display an Android Notification.

```
Sender sender = new Sender("<yourAPIkey>")

Notification n = new Notification();
n.setTitle("Some Title");
n.setBody("Some Text");
n.setIcon("notification_icon");

SimpleMessage message = new SimpleMessage();
message.setTo("<client registration_id>");
message.setNotification(n);

//blocking call
sender.sendMessageNoRetry(message);
```

## Limitations

GCM is only a java client for GCM Server which doesn't handle the server result in any ways.
It takes a message, delivers it, returns the server result.


## Changelog

### 0.3
* fixes SimpleMessageResponse API

### 0.2
* adds Notification Constructor with required fields
* adds Sender.sendMessage(...) with exponential backoff

### 0.1
* initial Version


##License

Copyright 2015 Dominik Kontner

Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
