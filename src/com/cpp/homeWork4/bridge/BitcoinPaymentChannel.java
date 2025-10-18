package com.cpp.homeWork4.bridge;

public class BitcoinPaymentChannel extends PaymentChannel {
    public BitcoinPaymentChannel(String orderID, NotificationChannel notificationChannel) {
        this.validateInputs(orderID, notificationChannel);
        this.notificationChannel = notificationChannel;
        this.paymentChannel = PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL;
        this.orderID = orderID;
    }

    private void validateInputs(String orderID, NotificationChannel notificationChannel) {
        if (orderID == null) {
            throw new IllegalArgumentException("The parameter 'orderID' cannot be null");
        }

        if (notificationChannel == null) {
            throw new IllegalArgumentException("The parameter 'notificationChannel' cannot be null");
        }
    }
}
