package com.cpp.homeWork4.decorator;

public abstract class Topping implements Item {
    protected Toppings name;
    protected Item foodItem;
    protected double price;

    public String getItemName() {
        return this.name.toString();
    }

    public double getPrice() {
        return this.price + this.foodItem.getPrice();
    }

    public String prepare() {
        return String.format("%s\nAdding topping: %s, Price: %f", foodItem.prepare(), this.name, this.price);
    }
}
