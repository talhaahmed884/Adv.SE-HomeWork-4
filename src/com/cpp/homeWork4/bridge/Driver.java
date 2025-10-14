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
        System.out.println("----------------------------------------------");
    }
}
