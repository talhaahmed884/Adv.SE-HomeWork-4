package com.cpp.homeWork4.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestCases {
    @Test
    public void TestFoodItems() {
//        Testing Burger food item
        Item item = new Burger();
        Assertions.assertInstanceOf(Burger.class, item);
        Assertions.assertEquals(FoodItems.BURGER.toString(), item.getItemName());
        Assertions.assertEquals(3.5, item.getPrice());

//        Testing Fries food item
        item = new Fries();
        Assertions.assertInstanceOf(Fries.class, item);
        Assertions.assertEquals(FoodItems.FRIES.toString(), item.getItemName());
        Assertions.assertEquals(1.75, item.getPrice());

//        Testing Hot Dog food item
        item = new HotDog();
        Assertions.assertInstanceOf(HotDog.class, item);
        Assertions.assertEquals(FoodItems.HOT_DOG.toString(), item.getItemName());
        Assertions.assertEquals(1.5, item.getPrice());
    }

    @Test
    public void TestToppings() {
//        Testing Ketchup topping
        Item item = new Ketchup(new Burger());
        Assertions.assertInstanceOf(Ketchup.class, item);
        Assertions.assertEquals(Toppings.KETCHUP.toString(), item.getItemName());
        Assertions.assertEquals(0.5, item.getPrice() - 3.5);
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Ketchup(null));

//        Testing Cheese topping
        item = new Cheese(new Burger());
        Assertions.assertInstanceOf(Cheese.class, item);
        Assertions.assertEquals(Toppings.CHEESE.toString(), item.getItemName());
        Assertions.assertEquals(5.5, item.getPrice() - 3.5);
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Cheese(null));

//        Testing Onion topping
        item = new Onion(new Burger());
        Assertions.assertInstanceOf(Onion.class, item);
        Assertions.assertEquals(Toppings.ONION.toString(), item.getItemName());
        Assertions.assertEquals(1.5, item.getPrice() - 3.5);
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Onion(null));
    }

    @Test
    public void TestLoyaltyStatuses() {
//        Testing No Loyalty status
        LoyaltyStatus status = new NoLoyalty();
        Assertions.assertInstanceOf(NoLoyalty.class, status);
        Assertions.assertEquals(LoyaltyStatuses.NO_LOYALTY.toString(), status.getStatus());
        Assertions.assertEquals(LoyaltyStatuses.NO_LOYALTY.getDiscount(), status.getDiscount());

//        Testing Bronze status
        status = new Bronze();
        Assertions.assertInstanceOf(Bronze.class, status);
        Assertions.assertEquals(LoyaltyStatuses.BRONZE.toString(), status.getStatus());
        Assertions.assertEquals(LoyaltyStatuses.BRONZE.getDiscount(), status.getDiscount());

//        Testing Silver status
        status = new Silver();
        Assertions.assertInstanceOf(Silver.class, status);
        Assertions.assertEquals(LoyaltyStatuses.SILVER.toString(), status.getStatus());
        Assertions.assertEquals(LoyaltyStatuses.SILVER.getDiscount(), status.getDiscount());

//        Testing Gold status
        status = new Gold();
        Assertions.assertInstanceOf(Gold.class, status);
        Assertions.assertEquals(LoyaltyStatuses.GOLD.toString(), status.getStatus());
        Assertions.assertEquals(LoyaltyStatuses.GOLD.getDiscount(), status.getDiscount());

//        Testing Platinum status
        status = new Platinum();
        Assertions.assertInstanceOf(Platinum.class, status);
        Assertions.assertEquals(LoyaltyStatuses.PLATINUM.toString(), status.getStatus());
        Assertions.assertEquals(LoyaltyStatuses.PLATINUM.getDiscount(), status.getDiscount());
    }

    @Test
    public void TestOrders1() {
        Order order = new Order();
        order.addItem(new Burger());
        order.addItem(new Ketchup(new Cheese(new Burger())));
        order.addItem(new Onion(new HotDog()));
        order.addItem(new Ketchup(new Fries()));

        Assertions.assertInstanceOf(Order.class, order);
        Assertions.assertEquals(18.25, order.calculateBill(new NoLoyalty()));
        Assertions.assertEquals(16.75, order.calculateBill(new Bronze()));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> order.addItem(null));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> order.calculateBill(null));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> order.printReceipt(null));

        String builder = """
                Item-1
                Preparing food: Burger, Price: 3.500
                
                Item-2
                Preparing food: Burger, Price: 3.500
                Adding topping: Cheese, Price: 5.500
                Adding topping: Ketchup, Price: 0.500
                
                Item-3
                Preparing food: Hot Dog, Price: 1.500
                Adding topping: Onion, Price: 1.500
                
                Item-4
                Preparing food: Fries, Price: 1.750
                Adding topping: Ketchup, Price: 0.500
                
                Loyalty Status: Gold, Discount: 5.000
                Total Bill: 13.250
                """;

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteStream);
        PrintStream oldPrintStream = System.out;
        System.setOut(printStream);
        order.printReceipt(new Gold());
        System.setOut(oldPrintStream);

        Assertions.assertEquals(builder, byteStream.toString());
    }

    @Test
    public void TestOrders2() {
        Order order = new Order();
        order.addItem(new Ketchup(new Cheese(new Onion(new Burger()))));
        order.addItem(new Ketchup(new Ketchup(new Onion(new Cheese(new HotDog())))));
        order.addItem(new Fries());
        order.addItem(new Cheese(new Ketchup(new Fries())));
        order.addItem(new Cheese(new Onion(new Burger())));
        order.addItem(new Onion(new Onion(new HotDog())));

        Assertions.assertInstanceOf(Order.class, order);
        Assertions.assertEquals(45, order.calculateBill(new NoLoyalty()));
        Assertions.assertEquals(38.5, order.calculateBill(new Platinum()));
        Assertions.assertEquals(41.5, order.calculateBill(new Silver()));

        String builder = """
                Item-1
                Preparing food: Burger, Price: 3.500
                Adding topping: Onion, Price: 1.500
                Adding topping: Cheese, Price: 5.500
                Adding topping: Ketchup, Price: 0.500
                
                Item-2
                Preparing food: Hot Dog, Price: 1.500
                Adding topping: Cheese, Price: 5.500
                Adding topping: Onion, Price: 1.500
                Adding topping: Ketchup, Price: 0.500
                Adding topping: Ketchup, Price: 0.500
                
                Item-3
                Preparing food: Fries, Price: 1.750
                
                Item-4
                Preparing food: Fries, Price: 1.750
                Adding topping: Ketchup, Price: 0.500
                Adding topping: Cheese, Price: 5.500
                
                Item-5
                Preparing food: Burger, Price: 3.500
                Adding topping: Onion, Price: 1.500
                Adding topping: Cheese, Price: 5.500
                
                Item-6
                Preparing food: Hot Dog, Price: 1.500
                Adding topping: Onion, Price: 1.500
                Adding topping: Onion, Price: 1.500
                
                Loyalty Status: Bronze, Discount: 1.500
                Total Bill: 43.500
                """;

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteStream);
        PrintStream oldPrintStream = System.out;
        System.setOut(printStream);
        order.printReceipt(new Bronze());
        System.setOut(oldPrintStream);

        Assertions.assertEquals(builder, byteStream.toString());
    }

    @Test
    public void TestOrders3() {
        Order order = new Order();
        order.addItem(new Burger());
        order.addItem(new HotDog());
        order.addItem(new Fries());
        Assertions.assertEquals(6.75, order.calculateBill(new NoLoyalty()));
        Assertions.assertEquals(0.25, order.calculateBill(new Platinum()));
        Assertions.assertEquals(3.25, order.calculateBill(new Silver()));

        order = new Order();
        order.addItem(new Burger());
        order.addItem(new HotDog());
        Assertions.assertEquals(5, order.calculateBill(new NoLoyalty()));
        Assertions.assertEquals(0, order.calculateBill(new Gold()));
        Assertions.assertEquals(0, order.calculateBill(new Platinum()));
    }
}
