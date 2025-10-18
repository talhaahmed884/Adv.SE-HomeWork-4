package com.cpp.homeWork4.bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestCases {
    @Test
    public void CashPaymentTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel("1031", new EmailNotificationChannel("markZane@gmail.com"));
        Assertions.assertEquals(PaymentChannelType.CASH_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertInstanceOf(CashPaymentChannel.class, paymentChannel);
        Assertions.assertEquals("1031", paymentChannel.getOrderID());
        Assertions.assertEquals("markZane@gmail.com", paymentChannel.getNotificationChannel().getRecipient());

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new CashPaymentChannel(null, new EmailNotificationChannel("markZane@gmail.com")));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new CashPaymentChannel("1034", null));
    }

    @Test
    public void CashPaymentWithEmailNotificationTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel("1320", new EmailNotificationChannel("markZane@gmail.com"));
        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertEquals(NotificationChannelType.EMAIL_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertEquals("markZane@gmail.com", paymentChannel.getNotificationChannel().getRecipient());
        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new EmailNotificationChannel(null));
    }

    @Test
    public void CashPaymentWithSMSNotificationTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel("1041", new SMSNotificationChannel("9148529184"));
        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertEquals(NotificationChannelType.SMS_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertEquals("1041", paymentChannel.getOrderID());
        Assertions.assertEquals("9148529184", paymentChannel.getNotificationChannel().getRecipient());
        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new SMSNotificationChannel(null));
    }

    @Test
    public void CashPaymentWithPushMessageNotificationTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel("1041", new PushMessageNotificationChannel("ID:Mark-Zac"));
        Assertions.assertInstanceOf(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertEquals(NotificationChannelType.PUSH_MESSAGE_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertEquals("1041", paymentChannel.getOrderID());
        Assertions.assertEquals("ID:Mark-Zac", paymentChannel.getNotificationChannel().getRecipient());
        Assertions.assertInstanceOf(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new PushMessageNotificationChannel(null));
    }

    @Test
    public void CashPaymentWithEmailNotificationExecutionTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel("1041", new EmailNotificationChannel("marZac@gmail.com"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE.toString(), "1041", PaymentChannelType.CASH_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n", "marZac@gmail.com", NotificationChannelType.EMAIL_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        printStream.close();
    }

    @Test
    public void CashPaymentWithSMSNotificationExecutionTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel("1041", new SMSNotificationChannel("9148529184"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE.toString(), "1041", PaymentChannelType.CASH_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n", "9148529184", NotificationChannelType.SMS_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        printStream.close();
    }

    @Test
    public void CashPaymentWithPushMessageNotificationExecutionTest() {
        PaymentChannel paymentChannel = new CashPaymentChannel("1041", new PushMessageNotificationChannel("ID:Mark-Zac"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE.toString(), "1041", PaymentChannelType.CASH_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n", "ID:Mark-Zac", NotificationChannelType.PUSH_MESSAGE_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        printStream.close();
    }

    @Test
    public void OnlinePaymentTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel("1041", new EmailNotificationChannel("markZac@gmail.com"), OnlinePaymentChannelType.CREDIT_CARD_PAYMENT_CHANNEL);
        Assertions.assertEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertInstanceOf(OnlinePaymentChannel.class, paymentChannel);
        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertEquals("1041", paymentChannel.getOrderID());
        Assertions.assertEquals("markZac@gmail.com", paymentChannel.getNotificationChannel().getRecipient());

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OnlinePaymentChannel(null, new EmailNotificationChannel("markZac@gmail.com"), OnlinePaymentChannelType.CREDIT_CARD_PAYMENT_CHANNEL));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OnlinePaymentChannel("1041", null, OnlinePaymentChannelType.CREDIT_CARD_PAYMENT_CHANNEL));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OnlinePaymentChannel("1041", new EmailNotificationChannel("markZac@gmail.com"), null));
    }

    @Test
    public void OnlinePaymentWithEmailNotificationTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel("1041", new EmailNotificationChannel("markZac@gmail.com"), OnlinePaymentChannelType.CREDIT_CARD_PAYMENT_CHANNEL);
        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertEquals(NotificationChannelType.EMAIL_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertEquals(PaymentChannelType.ONLINE_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertInstanceOf(OnlinePaymentChannel.class, paymentChannel);
        Assertions.assertEquals("markZac@gmail.com", paymentChannel.getNotificationChannel().getRecipient());
    }

    @Test
    public void OnlinePaymentWithSMSNotificationTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel("1041", new SMSNotificationChannel("9148529184"), OnlinePaymentChannelType.CREDIT_CARD_PAYMENT_CHANNEL);
        Assertions.assertInstanceOf(OnlinePaymentChannel.class, paymentChannel);
        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertEquals(NotificationChannelType.SMS_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertEquals("1041", paymentChannel.getOrderID());
        Assertions.assertEquals("9148529184", paymentChannel.getNotificationChannel().getRecipient());

    }

    @Test
    public void OnlinePaymentWithPushMessageNotificationTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel("1041", new PushMessageNotificationChannel("ID:Mark-Zac"), OnlinePaymentChannelType.PAYPAL_PAYMENT_CHANNEL);
        Assertions.assertInstanceOf(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertEquals(NotificationChannelType.PUSH_MESSAGE_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertInstanceOf(OnlinePaymentChannel.class, paymentChannel);
        Assertions.assertEquals("ID:Mark-Zac", paymentChannel.getNotificationChannel().getRecipient());
    }

    @Test
    public void OnlinePaymentWithEmailNotificationExecutionTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel("1041", new EmailNotificationChannel("markZac@gmail.com"), OnlinePaymentChannelType.CREDIT_CARD_PAYMENT_CHANNEL);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.ONLINE_PAYMENT_CHANNEL_MESSAGE.toString(), "1041", OnlinePaymentChannelType.CREDIT_CARD_PAYMENT_CHANNEL, PaymentChannelType.ONLINE_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n", "markZac@gmail.com", NotificationChannelType.EMAIL_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        printStream.close();
    }

    @Test
    public void OnlinePaymentWithSMSNotificationExecutionTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel("1041", new SMSNotificationChannel("9148529184"), OnlinePaymentChannelType.PAYPAL_PAYMENT_CHANNEL);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.ONLINE_PAYMENT_CHANNEL_MESSAGE.toString(), "1041", OnlinePaymentChannelType.PAYPAL_PAYMENT_CHANNEL, PaymentChannelType.ONLINE_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n", "9148529184", NotificationChannelType.SMS_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        printStream.close();
    }

    @Test
    public void OnlinePaymentWithPushMessageNotificationExecutionTest() {
        PaymentChannel paymentChannel = new OnlinePaymentChannel("1041", new PushMessageNotificationChannel("ID:Mark-Zac"), OnlinePaymentChannelType.PAYPAL_PAYMENT_CHANNEL);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.ONLINE_PAYMENT_CHANNEL_MESSAGE.toString(), "1041", OnlinePaymentChannelType.PAYPAL_PAYMENT_CHANNEL, PaymentChannelType.ONLINE_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n", "ID:Mark-Zac", NotificationChannelType.PUSH_MESSAGE_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        printStream.close();
    }

    @Test
    public void BitcoinPaymentTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel("1041", new EmailNotificationChannel("markZac@gmail.com"));
        Assertions.assertEquals(PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL, paymentChannel.getPaymentChannelType());
        Assertions.assertInstanceOf(BitcoinPaymentChannel.class, paymentChannel);
        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertEquals("1041", paymentChannel.getOrderID());
        Assertions.assertEquals("markZac@gmail.com", paymentChannel.getNotificationChannel().getRecipient());

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new BitcoinPaymentChannel(null, new EmailNotificationChannel("markZac@gmail.com")));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new BitcoinPaymentChannel("1041", null));
    }

    @Test
    public void BitcoinPaymentWithEmailNotificationTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel("1041", new EmailNotificationChannel("markZac@gmail.com"));
        Assertions.assertInstanceOf(EmailNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertInstanceOf(BitcoinPaymentChannel.class, paymentChannel);
        Assertions.assertEquals(NotificationChannelType.EMAIL_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertEquals("markZac@gmail.com", paymentChannel.getNotificationChannel().getRecipient());
    }

    @Test
    public void BitcoinPaymentWithSMSNotificationTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel("1041", new SMSNotificationChannel("9148529184"));
        Assertions.assertInstanceOf(SMSNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertInstanceOf(BitcoinPaymentChannel.class, paymentChannel);
        Assertions.assertEquals(NotificationChannelType.SMS_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertEquals("9148529184", paymentChannel.getNotificationChannel().getRecipient());
    }

    @Test
    public void BitcoinPaymentWithPushMessageNotificationTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel("1041", new PushMessageNotificationChannel("ID:Mark-Zac"));
        Assertions.assertInstanceOf(PushMessageNotificationChannel.class, paymentChannel.getNotificationChannel());
        Assertions.assertInstanceOf(BitcoinPaymentChannel.class, paymentChannel);
        Assertions.assertEquals(NotificationChannelType.PUSH_MESSAGE_CHANNEL.toString(), paymentChannel.getNotificationChannel().toString());
        Assertions.assertEquals("ID:Mark-Zac", paymentChannel.getNotificationChannel().getRecipient());
    }

    @Test
    public void BitcoinPaymentWithEmailNotificationExecutionTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel("1041", new EmailNotificationChannel("markZac@gmail.com"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE.toString(), "1041", PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n", "markZac@gmail.com", NotificationChannelType.EMAIL_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        printStream.close();
    }

    @Test
    public void BitcoinPaymentWithSMSNotificationExecutionTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel("1041", new SMSNotificationChannel("9148529184"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE.toString(), "1041", PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n", "9148529184", NotificationChannelType.SMS_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        printStream.close();
    }

    @Test
    public void BitcoinPaymentWithPushMessageNotificationExecutionTest() {
        PaymentChannel paymentChannel = new BitcoinPaymentChannel("1041", new PushMessageNotificationChannel("ID:Mark-Zac"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        PrintStream oldStream = System.out;
        paymentChannel.makePayment();
        String correctPaymentMessage = String.format(ChannelMessages.PAYMENT_CHANNEL_MESSAGE.toString(), "1041", PaymentChannelType.BIT_COIN_PAYMENT_CHANNEL);
        String correctNotificationMessage = String.format(ChannelMessages.NOTIFICATION_CHANNEL_MESSAGE + "\n", "ID:Mark-Zac", NotificationChannelType.PUSH_MESSAGE_CHANNEL);
        Assertions.assertEquals(correctPaymentMessage + correctNotificationMessage, outputStream.toString());
        System.setOut(oldStream);
        printStream.close();
    }
}
