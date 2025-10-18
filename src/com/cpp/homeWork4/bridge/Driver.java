package com.cpp.homeWork4.bridge;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Part 1");
        System.out.println("----------------------------------------------");
        System.out.println();
//        online payment with Email notification channel
        PaymentChannel paymentChannel1 = new OnlinePaymentChannel("5639", new EmailNotificationChannel("nasirMU@gmail.com"), OnlinePaymentChannelType.CREDIT_CARD_PAYMENT_CHANNEL);
        paymentChannel1.makePayment();

//        online payment with SMS notification channel
        PaymentChannel paymentChannel2 = new OnlinePaymentChannel("1952", new SMSNotificationChannel("9245298751"), OnlinePaymentChannelType.PAYPAL_PAYMENT_CHANNEL);
        paymentChannel2.makePayment();

//        cash payment with Email notification channel
        PaymentChannel paymentChannel3 = new CashPaymentChannel("1940", new EmailNotificationChannel("markzak13@yahoo.com"));
        paymentChannel3.makePayment();

//        cash payment with SMS notification channel
        PaymentChannel paymentChannel4 = new CashPaymentChannel("2095", new SMSNotificationChannel("9840195302"));
        paymentChannel4.makePayment();
        System.out.println("----------------------------------------------\n");

        System.out.println("Part 2");
        System.out.println("----------------------------------------------");
        System.out.println();

//        bitcoin payment with Email notification channel
        PaymentChannel paymentChannel5 = new BitcoinPaymentChannel("1042", new EmailNotificationChannel("zakNas243@outlook.com"));
        paymentChannel5.makePayment();

//        bitcoin payment with SMS notification channel
        PaymentChannel paymentChannel6 = new BitcoinPaymentChannel("0942", new SMSNotificationChannel("1248719764"));
        paymentChannel6.makePayment();

        System.out.println("----------------------------------------------\n");

        System.out.println("Part 3");
        System.out.println("----------------------------------------------");
        System.out.println();

//        online payment with Push message notification channel
        PaymentChannel paymentChannel7 = new OnlinePaymentChannel("9013", new PushMessageNotificationChannel("ID:Nasir-Jamal"), OnlinePaymentChannelType.PAYPAL_PAYMENT_CHANNEL);
        paymentChannel7.makePayment();

//        cash payment with Push message notification channel
        PaymentChannel paymentChannel8 = new CashPaymentChannel("1031", new PushMessageNotificationChannel("ID:Calvin-Joy"));
        paymentChannel8.makePayment();

//        bitcoin payment with Push message notification channel
        PaymentChannel paymentChannel9 = new BitcoinPaymentChannel("0942", new PushMessageNotificationChannel("ID:Mav-Harry"));
        paymentChannel9.makePayment();

        System.out.println("----------------------------------------------\n");
    }
}
