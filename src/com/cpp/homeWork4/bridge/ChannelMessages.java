package com.cpp.homeWork4.bridge;

public enum ChannelMessages {
    NOTIFICATION_CHANNEL_MESSAGE("Delivered notification to %s through %s.\n"),
    PAYMENT_CHANNEL_MESSAGE("Made payment for Order ID %s through %s.\n"),
    ONLINE_PAYMENT_CHANNEL_MESSAGE("Made payment for Order ID %s through %s %s.\n");

    private final String displayName;

    ChannelMessages(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
