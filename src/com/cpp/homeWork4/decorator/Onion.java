package com.cpp.homeWork4.decorator;

public class Onion extends Topping {
    public Onion(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("The 'item' parameter cannot be null");
        }

        this.name = Toppings.ONION;
        this.price = 1.5;
        this.foodItem = item;
    }

    public String prepare() {
        return super.prepare();
    }
}
