package com.cpp.homeWork4.decorator;

public abstract class FoodItem implements Item {
    protected FoodItems name;
    protected double price;

    public String getItemName() {
        return this.name.toString();
    }

    public double getPrice() {
        return this.price;
    }

    public String prepare() {
        return String.format("Preparing food: %s, Price: %.3f", this.name, this.price);
    }
}
