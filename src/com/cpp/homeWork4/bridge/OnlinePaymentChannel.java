package com.cpp.homeWork4.bridge;

public class OnlinePaymentChannel extends PaymentChannel {
    private final OnlinePaymentChannelType type;

    public OnlinePaymentChannel(String orderID, NotificationChannel notificationChannel, OnlinePaymentChannelType type) {
        this.validateInputs(orderID, notificationChannel, type);
        this.notificationChannel = notificationChannel;
        this.paymentChannel = PaymentChannelType.ONLINE_PAYMENT_CHANNEL;
        this.type = type;
        this.orderID = orderID;
    }

    private void validateInputs(String orderID, NotificationChannel notificationChannel, OnlinePaymentChannelType type) {
        if (orderID == null)
            throw new IllegalArgumentException("The parameter 'orderID' cannot be null");
        if (notificationChannel == null)
            throw new IllegalArgumentException("The parameter 'notificationChannel' cannot be null");
        if (type == null)
            throw new IllegalArgumentException("The parameter 'type' cannot be null");
    }

    @Override
    public void makePayment() {
        System.out.printf(ChannelMessages.ONLINE_PAYMENT_CHANNEL_MESSAGE.toString(), this.orderID, type.toString(), paymentChannel.toString());
        this.notificationChannel.deliverNotification();
        System.out.println();
    }
}
