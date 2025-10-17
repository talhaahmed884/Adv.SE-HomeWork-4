package com.cpp.homeWork4.decorator;

import java.util.ArrayList;

public class Order {
    private final ArrayList<Item> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("The 'item' parameter cannot be null");
        }

        items.add(item);
    }

    public void printReceipt(LoyaltyStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("The 'status' parameter cannot be null");
        }

        int counter = 0;
        for (Item item : items) {
            counter++;
            System.out.printf("Item-%d\n", counter);
            System.out.println(item.prepare());
            System.out.println();
        }
        System.out.printf("Loyalty Discount: %f\n", status.getDiscount());
        System.out.println("Total Bill: " + this.calculateBill(status));
    }

    public double calculateBill(LoyaltyStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("The 'status' parameter cannot be null");
        }

        double totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }

        totalPrice -= status.getDiscount();
        return totalPrice > 0 ? totalPrice : 0.0;
    }
}
