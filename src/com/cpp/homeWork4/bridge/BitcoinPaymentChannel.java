package com.cpp.homeWork4.bridge;

public class BitcoinPaymentChannel extends PaymentChannel {
    public BitcoinPaymentChannel(String orderID, NotificationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
        this.paymentChannel = PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL;
        this.orderID = orderID;
    }
}
