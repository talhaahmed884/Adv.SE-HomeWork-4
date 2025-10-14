package com.cpp.homeWork4.bridge;

public enum NotificationChannelType {
    EMAIL_CHANNEL("Email channel"),
    SMS_CHANNEL("SMS channel");

    private final String displayName;

    NotificationChannelType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
