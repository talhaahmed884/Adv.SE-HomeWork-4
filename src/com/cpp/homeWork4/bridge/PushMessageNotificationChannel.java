package com.cpp.homeWork4.bridge;

public class PushMessageNotificationChannel extends AbstractNotificationChannel {
    public PushMessageNotificationChannel(String recipient) {
        this.recipient = recipient;
        this.channelType = NotificationChannelType.PUSH_MESSAGE_CHANNEL;
    }

    @Override
    public String toString() {
        return this.channelType.toString();
    }
}
