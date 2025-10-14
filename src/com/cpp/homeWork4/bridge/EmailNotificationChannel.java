package com.cpp.homeWork4.bridge;

public class EmailNotificationChannel implements NotificationChannel {
    @Override
    public void deliverNotification() {
        System.out.printf((ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE) + "\n", NotificationChannelType.EMAIL_CHANNEL);
    }
}
