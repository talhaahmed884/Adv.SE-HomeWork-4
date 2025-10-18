package com.cpp.homeWork4.decorator;

public class Fries extends FoodItem {
    public Fries() {
        this.price = 1.75;
        this.name = FoodItems.FRIES;
    }

    @Override
    public String prepare() {
        return super.prepare();
    }
}
