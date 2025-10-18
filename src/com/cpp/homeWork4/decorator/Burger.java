package com.cpp.homeWork4.decorator;

public class Burger extends FoodItem {
    public Burger() {
        this.price = 3.5;
        this.name = FoodItems.BURGER;
    }

    @Override
    public String prepare() {
        return super.prepare();
    }
}
