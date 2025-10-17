package com.cpp.homeWork4.decorator;

public enum FoodItems {
    BURGER("Burger"),
    FRIES("Fries"),
    HOT_DOG("Hot Dog");

    private final String displayName;

    FoodItems(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
