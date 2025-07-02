package com.example.legacy;
public class PriceFacade {
    private PriceCalculator calculator = new PriceCalculator();
    public int getPrice(int basePrice) {
        try {
            return calculator.getPriceWithTax(basePrice);
        } catch (ArithmeticException ex) {
            return 999;
        }
    }
    public PriceCalculator getCalculator() {
        return calculator;
    }
}
