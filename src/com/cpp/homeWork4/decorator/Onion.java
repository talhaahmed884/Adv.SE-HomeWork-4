package com.cpp.homeWork4.decorator;

public class Onion extends Topping {
    public Onion(Item item) {
        this.name = Toppings.ONION;
        this.price = 1.5;
        this.foodItem = item;
    }

    public String prepare() {
        return super.prepare();
    }
}
