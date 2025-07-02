package com.example.legacy;

public class PriceCalculator {
    public int getPriceWithTax(int basePrice) {
        return basePrice + calculateTax(basePrice);
    }

    private int calculateTax(int amount) {
        return (int)(amount * 0.2);
    }
}
