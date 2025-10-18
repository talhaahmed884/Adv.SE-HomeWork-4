package com.cpp.homeWork4.bridge;

public class EmailNotificationChannel extends AbstractNotificationChannel {
    public EmailNotificationChannel(String recipient) {
        if (recipient == null) {
            throw new IllegalArgumentException("The parameter 'recipient' cannot be null");
        }
        this.recipient = recipient;
        this.channelType = NotificationChannelType.EMAIL_CHANNEL;
    }

    @Override
    public String toString() {
        return this.channelType.toString();
    }
}
