package com.cpp.homeWork4.bridge;

public class CashPaymentChannel extends PaymentChannel {
    public CashPaymentChannel(String orderID, NotificationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
        this.paymentChannel = PaymentChannelType.CASH_PAYMENT_CHANNEL;
        this.orderID = orderID;
    }
}
