package com.cpp.homeWork4.bridge;

public abstract class AbstractNotificationChannel implements NotificationChannel {
    protected String recipient;
    protected NotificationChannelType channelType;

    @Override
    public void deliverNotification() {
        System.out.printf(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE.toString(), this.recipient, this.channelType);
    }

    public String getRecipient() {
        return this.recipient;
    }
}
