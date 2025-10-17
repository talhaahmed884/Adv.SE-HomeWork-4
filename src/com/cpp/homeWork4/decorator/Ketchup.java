package com.cpp.homeWork4.decorator;

public class Ketchup extends Topping {
    public Ketchup(Item foodItem) {
        this.name = Toppings.KETCHUP;
        this.price = 0.5;
        this.foodItem = foodItem;
    }

    public String prepare() {
        return super.prepare();
    }
}
