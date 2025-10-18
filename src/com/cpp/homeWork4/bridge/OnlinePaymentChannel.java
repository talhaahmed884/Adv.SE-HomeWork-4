package com.cpp.homeWork4.bridge;

public class OnlinePaymentChannel extends PaymentChannel {
    private final OnlinePaymentChannelType type;

    public OnlinePaymentChannel(String orderID, NotificationChannel notificationChannel, OnlinePaymentChannelType type) {
        this.notificationChannel = notificationChannel;
        this.paymentChannel = PaymentChannelType.ONLINE_PAYMENT_CHANNEL;
        this.type = type;
        this.orderID = orderID;
    }

    @Override
    public void makePayment() {
        System.out.printf(ChannelMessages.ONLINE_PAYMENT_CHANNEL_MESSAGE.toString(), this.orderID, type.toString(), paymentChannel.toString());
        this.notificationChannel.deliverNotification();
        System.out.println();
    }
}
