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
        Assertions.assertNotEquals(PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());

        Assertions.assertInstanceOf(CashPaymentChannel.class, paymentChannel);
        Assertions.assertNotEquals(OnlinePaymentChannel.class, paymentChannel);
        Assertions.assertNotEquals(BitcoinPaymentChannel.class, paymentChannel);
    }

    @Test
    public void CashPaymentWithEmailNotificationTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel(new EmailNotificationChannel());

        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());

        Assertions.assertEquals(NotificationChannelType.EMAIL_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.SMS_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.PUSH_MESSAGE_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
    }

    @Test
    public void CashPaymentWithSMSNotificationTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel(new SMSNotificationChannel());

        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());

        Assertions.assertEquals(NotificationChannelType.SMS_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.EMAIL_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.PUSH_MESSAGE_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
    }

    @Test
    public void CashPaymentWithPushMessageNotificationTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel(new PushMessageNotificationChannel());

        Assertions.assertInstanceOf(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());

        Assertions.assertEquals(NotificationChannelType.PUSH_MESSAGE_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.SMS_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.EMAIL_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
    }

    @Test
    public void CashPaymentWithEmailNotificationExecutionTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel(new EmailNotificationChannel());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE + "\n", PaymentChannelType.CASH_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.EMAIL_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        oldStream.close();
        printStream.close();
    }

    @Test
    public void CashPaymentWithSMSNotificationExecutionTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel(new SMSNotificationChannel());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE + "\n", PaymentChannelType.CASH_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.SMS_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        oldStream.close();
        printStream.close();
    }

    @Test
    public void CashPaymentWithPushMessageNotificationExecutionTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel(new PushMessageNotificationChannel());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE + "\n", PaymentChannelType.CASH_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.PUSH_MESSAGE_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
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
        Assertions.assertNotEquals(PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());

        Assertions.assertInstanceOf(OnlinePaymentChannel.class, paymentChannel);
        Assertions.assertNotEquals(CashPaymentChannel.class, paymentChannel);
        Assertions.assertNotEquals(BitcoinPaymentChannel.class, paymentChannel);
    }

    @Test
    public void OnlinePaymentWithEmailNotificationTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel(new EmailNotificationChannel());

        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());

        Assertions.assertEquals(NotificationChannelType.EMAIL_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.SMS_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.PUSH_MESSAGE_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
    }

    @Test
    public void OnlinePaymentWithSMSNotificationTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel(new SMSNotificationChannel());

        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());

        Assertions.assertEquals(NotificationChannelType.SMS_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.EMAIL_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.PUSH_MESSAGE_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
    }

    @Test
    public void OnlinePaymentWithPushMessageNotificationTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel(new PushMessageNotificationChannel());

        Assertions.assertInstanceOf(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());

        Assertions.assertEquals(NotificationChannelType.PUSH_MESSAGE_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.SMS_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.EMAIL_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
    }

    @Test
    public void OnlinePaymentWithEmailNotificationExecutionTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel(new EmailNotificationChannel());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE + "\n", PaymentChannelType.ONLINE_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.EMAIL_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        oldStream.close();
        printStream.close();
    }

    @Test
    public void OnlinePaymentWithSMSNotificationExecutionTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel(new SMSNotificationChannel());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE + "\n", PaymentChannelType.ONLINE_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.SMS_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        oldStream.close();
        printStream.close();
    }

    @Test
    public void OnlinePaymentWithPushMessageNotificationExecutionTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel(new PushMessageNotificationChannel());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE + "\n", PaymentChannelType.ONLINE_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.PUSH_MESSAGE_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        oldStream.close();
        printStream.close();
    }

    @Test
    public void BitcoinPaymentTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel(new EmailNotificationChannel());

        Assertions.assertEquals(PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertNotEquals(PaymentChannelType.CASH_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());

        Assertions.assertInstanceOf(BitcoinPaymentChannel.class, paymentChannel);
        Assertions.assertNotEquals(CashPaymentChannel.class, paymentChannel);
        Assertions.assertNotEquals(OnlinePaymentChannel.class, paymentChannel);
    }

    @Test
    public void BitcoinPaymentWithEmailNotificationTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel(new EmailNotificationChannel());

        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());

        Assertions.assertEquals(NotificationChannelType.EMAIL_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.SMS_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.PUSH_MESSAGE_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
    }

    @Test
    public void BitcoinPaymentWithSMSNotificationTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel(new SMSNotificationChannel());

        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());

        Assertions.assertEquals(NotificationChannelType.SMS_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.EMAIL_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.PUSH_MESSAGE_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
    }

    @Test
    public void BitcoinPaymentWithPushMessageNotificationTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel(new PushMessageNotificationChannel());

        Assertions.assertInstanceOf(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertNotEquals(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());

        Assertions.assertEquals(NotificationChannelType.PUSH_MESSAGE_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.SMS_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertNotEquals(NotificationChannelType.EMAIL_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
    }

    @Test
    public void BitcoinPaymentWithEmailNotificationExecutionTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel(new EmailNotificationChannel());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE + "\n", PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.EMAIL_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        oldStream.close();
        printStream.close();
    }

    @Test
    public void BitcoinPaymentWithSMSNotificationExecutionTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel(new SMSNotificationChannel());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE + "\n", PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.SMS_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        oldStream.close();
        printStream.close();
    }

    @Test
    public void BitcoinPaymentWithPushMessageNotificationExecutionTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel(new PushMessageNotificationChannel());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE + "\n", PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n\n", NotificationChannelType.PUSH_MESSAGE_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        oldStream.close();
        printStream.close();
    }
}
