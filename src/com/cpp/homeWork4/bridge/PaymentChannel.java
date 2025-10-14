package com.cpp.homeWork4.bridge;

public abstract class PaymentChannel {
    protected PaymentChannelType paymentChannel;
    protected NotificationChannel notificationChannel;

    public abstract void makePayment();

    public PaymentChannelType getPaymentChannelType() {
        return this.paymentChannel;
    }

    public NotificationChannel getNotificationChannel() {
        return this.notificationChannel;
    }
}
