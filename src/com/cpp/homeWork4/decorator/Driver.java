package com.cpp.homeWork4.decorator;

public class Driver {
    //    TODO: add error handling
    public static void main(String[] args) {
//        Order-1
        System.out.println("Order-1");
        Order order1 = new Order();
        order1.addItem(new Onion(new Ketchup(new Cheese(new Burger()))));
        order1.addItem(new Onion(new HotDog()));
        order1.addItem(new Fries());
        order1.printReceipt(new NoLoyalty());
        System.out.println();

//        Order-2
        System.out.println("Order-2");
        Order order2 = new Order();
        order2.addItem(new Burger());
        order2.addItem(new Cheese(new Burger()));
        order2.addItem(new Ketchup(new Fries()));
        order2.addItem(new Ketchup(new Burger()));
        order2.printReceipt(new Bronze());
        System.out.println();

//        Order-3
        System.out.println("Order-3");
        Order order3 = new Order();
        order3.addItem(new HotDog());
        order3.addItem(new Onion(new Cheese(new HotDog())));
        order3.addItem(new Cheese(new Ketchup(new Fries())));
        order3.printReceipt(new Gold());
        System.out.println();

//        Order-4
        System.out.println("Order-4");
        Order order4 = new Order();
        order4.addItem(new Burger());
        order4.addItem(new HotDog());
        order4.addItem(new HotDog());
        order4.printReceipt(new Platinum());
        System.out.println();

//        Order-5
        System.out.println("Order-5");
        Order order5 = new Order();
        order5.addItem(new Burger());
        order5.addItem(new HotDog());
        order5.printReceipt(new Platinum());
        System.out.println();
    }
}
