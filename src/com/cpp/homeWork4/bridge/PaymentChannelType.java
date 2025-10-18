package com.cpp.homeWork4.bridge;

public enum PaymentChannelType {
    ONLINE_PAYMENT_CHANNEL("Online payment channel"),
    CASH_PAYMENT_CHANNEL("Cash payment channel"),
    BIT_COIN_PAYMENT_CHANNEL("Bitcoin payment channel");

    private final String displayName;

    PaymentChannelType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
