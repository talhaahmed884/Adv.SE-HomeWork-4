package com.cpp.homeWork4.bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestCases {
    @Test
    public void CashPaymentTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel(new EmailNotificationChannel());
//        PaymentType test cases
        Assertions.assertEquals(PaymentChannelType.CASH_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
//        NotificationType test cases
        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
//        PaymentType test cases
        Assertions.assertInstanceOf(CashPaymentChannel.class, paymentChannel);
        Assertions.assertNotEquals(OnlinePaymentChannel.class, paymentChannel);
        Assertions.assertNotEquals(BitcoinPaymentChannel.class, paymentChannel);

//        Payment and notification channels output test case
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
//        NotificationType test cases
        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());

//        Payment and notification channels output test case
        System.setOut(printStream);
        paymentChannel.makePayment();
        correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.SMS_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        outputStream.reset();

        paymentChannel = new CashPaymentChannel(new PushMessageNotificationChannel());
//        NotificationType test cases
        Assertions.assertInstanceOf(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());

//        Payment and notification channels output test case
        System.setOut(printStream);
        paymentChannel.makePayment();
        correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.PUSH_MESSAGE_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);

        oldStream.close();
        printStream.close();
    }

    @Test
    public void OnlinePaymentTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel(new EmailNotificationChannel());
//        PaymentType test cases
        Assertions.assertEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.CASH_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
//        NotificationType test cases
        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());
//        PaymentType test cases
        Assertions.assertInstanceOf(OnlinePaymentChannel.class, paymentChannel);
        Assertions.assertNotEquals(CashPaymentChannel.class, paymentChannel);
        Assertions.assertNotEquals(BitcoinPaymentChannel.class, paymentChannel);

//        Payment and notification channels output test case
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
//        NotificationType test cases
        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());

//        Payment and notification channels output test case
        System.setOut(printStream);
        paymentChannel.makePayment();
        correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.SMS_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        outputStream.reset();

        paymentChannel = new OnlinePaymentChannel(new PushMessageNotificationChannel());
//        NotificationType test cases
        Assertions.assertInstanceOf(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());

//        Payment and notification channels output test case
        System.setOut(printStream);
        paymentChannel.makePayment();
        correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.PUSH_MESSAGE_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);

        oldStream.close();
        printStream.close();
    }

    @Test
    public void BitcoinPaymentTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel(new EmailNotificationChannel());
//        PaymentType test cases
        Assertions.assertEquals(PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.CASH_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
//        NotificationType test cases
        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());
//        PaymentType test cases
        Assertions.assertInstanceOf(BitcoinPaymentChannel.class, paymentChannel);
        Assertions.assertNotEquals(CashPaymentChannel.class, paymentChannel);
        Assertions.assertNotEquals(OnlinePaymentChannel.class, paymentChannel);

//        Payment and notification channels output test case
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE + "\n", PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.EMAIL_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        outputStream.reset();

        paymentChannel = new BitcoinPaymentChannel(new SMSNotificationChannel());
//        NotificationType test cases
        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());

//        Payment and notification channels output test case
        System.setOut(printStream);
        paymentChannel.makePayment();
        correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.SMS_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        outputStream.reset();

        paymentChannel = new BitcoinPaymentChannel(new PushMessageNotificationChannel());
//        NotificationType test cases
        Assertions.assertInstanceOf(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());

//        Payment and notification channels output test case
        System.setOut(printStream);
        paymentChannel.makePayment();
        correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.PUSH_MESSAGE_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());

        oldStream.close();
        printStream.close();
    }
}
