package com.cpp.homeWork4.bridge;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Part 1");
        System.out.println("----------------------------------------------");
        System.out.println();
//        online payment with Email notification channel
        PaymentChannel paymentChannel1 = new OnlinePaymentChannel(new EmailNotificationChannel());
        paymentChannel1.makePayment();

//        online payment with SMS notification channel
        PaymentChannel paymentChannel2 = new OnlinePaymentChannel(new SMSNotificationChannel());
        paymentChannel2.makePayment();

//        cash payment with Email notification channel
        PaymentChannel paymentChannel3 = new CashPaymentChannel(new EmailNotificationChannel());
        paymentChannel3.makePayment();

//        cash payment with SMS notification channel
        PaymentChannel paymentChannel4 = new CashPaymentChannel(new SMSNotificationChannel());
        paymentChannel4.makePayment();
        System.out.println("----------------------------------------------\n");

        System.out.println("Part 2");
        System.out.println("----------------------------------------------");
        System.out.println();

//        bitcoin payment with Email notification channel
        PaymentChannel paymentChannel5 = new BitcoinPaymentChannel(new EmailNotificationChannel());
        paymentChannel5.makePayment();

//        bitcoin payment with SMS notification channel
        PaymentChannel paymentChannel6 = new BitcoinPaymentChannel(new SMSNotificationChannel());
        paymentChannel6.makePayment();

        System.out.println("----------------------------------------------\n");

        System.out.println("Part 3");
        System.out.println("----------------------------------------------");
        System.out.println();

//        online payment with Push message notification channel
        PaymentChannel paymentChannel7 = new OnlinePaymentChannel(new PushMessageNotificationChannel());
        paymentChannel7.makePayment();

//        cash payment with Push message notification channel
        PaymentChannel paymentChannel8 = new CashPaymentChannel(new PushMessageNotificationChannel());
        paymentChannel8.makePayment();

//        bitcoin payment with Push message notification channel
        PaymentChannel paymentChannel9 = new BitcoinPaymentChannel(new PushMessageNotificationChannel());
        paymentChannel9.makePayment();

        System.out.println("----------------------------------------------\n");
    }
}
