package com.cpp.homeWork4.decorator;

public class HotDog extends FoodItem {
    public HotDog() {
        this.price = 1.5;
        this.name = FoodItems.HOT_DOG;
    }

    @Override
    public String prepare() {
        return super.prepare();
    }
}
