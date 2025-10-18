package com.cpp.homeWork4.bridge;

public enum OnlinePaymentChannelType {
    CREDIT_CARD_PAYMENT_CHANNEL("Credit Card"),
    PAYPAL_PAYMENT_CHANNEL("Paypal");

    private final String displayName;

    OnlinePaymentChannelType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
