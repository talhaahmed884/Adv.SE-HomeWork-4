package com.cpp.homeWork4.bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCases {
    @Test
    public void CashPaymentTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel(new EmailNotificationChannel());
        Assertions.assertEquals(PaymentChannelType.CASH_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertInstanceOf(CashPaymentChannel.class, paymentChannel);

        paymentChannel = new CashPaymentChannel(new SMSNotificationChannel());
        Assertions.assertEquals(PaymentChannelType.CASH_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertInstanceOf(CashPaymentChannel.class, paymentChannel);
    }

    @Test
    public void OnlinePaymentTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel(new EmailNotificationChannel());
        Assertions.assertEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.CASH_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertInstanceOf(OnlinePaymentChannel.class, paymentChannel);

        paymentChannel = new OnlinePaymentChannel(new SMSNotificationChannel());
        Assertions.assertEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.CASH_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertInstanceOf(OnlinePaymentChannel.class, paymentChannel);
    }
}
