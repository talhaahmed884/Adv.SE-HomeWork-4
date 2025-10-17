package com.cpp.homeWork4.decorator;

public enum LoyaltyStatuses {
    NO_LOYALTY("No loyalty", 0.0),
    BRONZE("Bronze", 1.5),
    SILVER("Silver", 3.5),
    GOLD("Gold", 5.0),
    PLATINUM("Platinum", 6.5);

    private final String displayName;
    private final double discount;

    LoyaltyStatuses(String displayName, double discount) {
        if (displayName == null) {
            throw new IllegalArgumentException("The 'displayName' parameter cannot be null");
        }

        this.displayName = displayName;
        this.discount = discount;
    }

    public double getDiscount() {
        return this.discount;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
