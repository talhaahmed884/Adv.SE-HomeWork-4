package com.cpp.homeWork4.bridge;

public class SMSNotificationChannel extends AbstractNotificationChannel {
    public SMSNotificationChannel(String recipient) {
        if (recipient == null) {
            throw new IllegalArgumentException("The parameter 'recipient' cannot be null");
        }
        this.recipient = recipient;
        this.channelType = NotificationChannelType.SMS_CHANNEL;
    }

    @Override
    public String toString() {
        return this.channelType.toString();
    }
}
