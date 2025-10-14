package com.cpp.homeWork4.bridge;

public class CashPaymentChannel extends PaymentChannel {
    public CashPaymentChannel(NotificationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
        this.paymentChannel = PaymentChannelType.CASH_PAYMENT_CHANNEL;
    }

    @Override
    public void makePayment() {
        System.out.printf((ChannelMessages.PAYMENT_CHANNEL_MESSAGE) + "\n", paymentChannel.toString());
        this.notificationChannel.deliverNotification();
        System.out.println();
    }
}
