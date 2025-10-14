package com.cpp.homeWork4.bridge;

public class BitcoinPaymentChannel extends PaymentChannel {
    public BitcoinPaymentChannel(NotificationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
        this.paymentChannel = PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL;
    }

    @Override
    public void makePayment() {
        System.out.printf((ChannelMessages.PAYMENT_CHANNEL_MESSAGE) + "\n", paymentChannel.toString());
        this.notificationChannel.deliverNotification();
        System.out.println();
    }
}
