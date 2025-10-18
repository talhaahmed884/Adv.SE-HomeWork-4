package com.cpp.homeWork4.decorator;

public class Cheese extends Topping {
    public Cheese(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("The 'item' parameter cannot be null");
        }

        this.name = Toppings.CHEESE;
        this.price = 5.5;
        this.foodItem = item;
    }

    public String prepare() {
        return super.prepare();
    }
}
