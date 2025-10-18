package com.cpp.homeWork4.bridge;

public abstract class PaymentChannel {
    protected PaymentChannelType paymentChannel;
    protected NotificationChannel notificationChannel;
    protected String orderID;

    public PaymentChannelType getPaymentChannelType() {
        return this.paymentChannel;
    }

    public NotificationChannel getNotificationChannel() {
        return this.notificationChannel;
    }

    public void makePayment() {
        System.out.printf(ChannelMessages.PAYMENT_CHANNEL_MESSAGE.toString(), this.orderID, paymentChannel.toString());
        this.notificationChannel.deliverNotification();
        System.out.println();
    }

    public String getOrderID() {
        return this.orderID;
    }
}
