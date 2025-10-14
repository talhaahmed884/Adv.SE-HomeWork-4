package com.cpp.homeWork4.bridge;

public enum ChannelMessages {
    NOTIFICATION_CHANNEL_MESSAGE("Delivered notification through %s."),
    PAYMENT_CHANNEL_MESSAGE("Made payment through %s.");

    private final String displayName;

    ChannelMessages(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
