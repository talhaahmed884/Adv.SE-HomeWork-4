package com.cpp.homeWork4.decorator;

public class Ketchup extends Topping {
    public Ketchup(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("The 'item' parameter cannot be null");
        }

        this.name = Toppings.KETCHUP;
        this.price = 0.5;
        this.foodItem = item;
    }

    public String prepare() {
        return super.prepare();
    }
}
