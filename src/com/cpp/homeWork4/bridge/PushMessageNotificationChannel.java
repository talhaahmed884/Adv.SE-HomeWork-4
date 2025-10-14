package com.cpp.homeWork4.bridge;

public class PushMessageNotificationChannel implements NotificationChannel {
    @Override
    public void deliverNotification() {
        System.out.printf((ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE) + "\n", NotificationChannelType.PUSH_MESSAGE_CHANNEL);
    }
}
