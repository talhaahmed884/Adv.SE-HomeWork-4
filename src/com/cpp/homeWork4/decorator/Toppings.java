package com.cpp.homeWork4.decorator;

public enum Toppings {
    KETCHUP("Ketchup"),
    CHEESE("Cheese"),
    ONION("Onion");

    private final String displayName;

    Toppings(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
