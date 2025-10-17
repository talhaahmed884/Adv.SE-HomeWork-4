package com.cpp.homeWork4.decorator;

public enum Toppings {
    KETCHUP("Ketchup"),
    CHEESE("Cheese"),
    ONION("Onion");

    private final String displayName;

    Toppings(String displayName) {
        if (displayName == null) {
            throw new IllegalArgumentException("The 'displayName' parameter cannot be null");
        }

        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
