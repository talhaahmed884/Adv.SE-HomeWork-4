package com.cpp.homeWork4.decorator;

public abstract class LoyaltyStatus {
    protected LoyaltyStatuses status;

    protected LoyaltyStatus(LoyaltyStatuses status) {
        this.status = status;
    }

    public String getStatus() {
        return status.toString();
    }

    public double getDiscount() {
        return this.status.getDiscount();
    }
}
