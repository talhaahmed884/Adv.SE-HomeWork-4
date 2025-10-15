package com.cpp.homeWork4.bridge;

public class SMSNotificationChannel implements NotificationChannel {
    @Override
    public void deliverNotification() {
        System.out.printf((ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE) + "\n", NotificationChannelType.SMS_CHANNEL);
    }

    @Override
    public String toString() {
        return NotificationChannelType.SMS_CHANNEL.toString();
    }
}
