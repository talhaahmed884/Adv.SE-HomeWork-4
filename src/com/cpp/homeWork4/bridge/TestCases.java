package com.cpp.homeWork4.bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestCases {
    @Test
    public void CashPaymentTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel(new EmailNotificationChannel());
        Assertions.assertEquals(PaymentChannelType.CASH_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertInstanceOf(CashPaymentChannel.class, paymentChannel);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE + "\n", PaymentChannelType.CASH_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.EMAIL_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        outputStream.reset();

        paymentChannel = new CashPaymentChannel(new SMSNotificationChannel());
        Assertions.assertEquals(PaymentChannelType.CASH_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertInstanceOf(CashPaymentChannel.class, paymentChannel);

        System.setOut(printStream);
        paymentChannel.makePayment();
        correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.SMS_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);

        oldStream.close();
        printStream.close();
    }

    @Test
    public void OnlinePaymentTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel(new EmailNotificationChannel());
        Assertions.assertEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.CASH_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertInstanceOf(OnlinePaymentChannel.class, paymentChannel);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE + "\n", PaymentChannelType.ONLINE_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.EMAIL_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        outputStream.reset();

        paymentChannel = new OnlinePaymentChannel(new SMSNotificationChannel());
        Assertions.assertEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.CASH_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertInstanceOf(OnlinePaymentChannel.class, paymentChannel);

        System.setOut(printStream);
        paymentChannel.makePayment();
        correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.SMS_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);

        oldStream.close();
        printStream.close();
    }
}
