package com.insurance.PremiumCalculator.model;

public enum RiskType {
    FIRE,
    THEFT;

    public float getCoefficient(double amount) {
        // Round off amount to 2 decimal places
        amount = Math.round(amount * 100) / 100.0;
        switch (this) {
            case FIRE:
                return amount > 100.0 ? 0.024f : 0.014f;
            case THEFT:
                return amount >= 15.0 ? 0.05f : 0.11f;
            default:
                return 0;
        }
    }
}
