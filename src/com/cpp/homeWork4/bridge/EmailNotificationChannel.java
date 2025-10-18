package com.cpp.homeWork4.bridge;

public class EmailNotificationChannel extends AbstractNotificationChannel {
    public EmailNotificationChannel(String recipient) {
        this.recipient = recipient;
        this.channelType = NotificationChannelType.EMAIL_CHANNEL;
    }

    @Override
    public String toString() {
        return this.channelType.toString();
    }
}
