package com.insurance.PremiumCalculator.model;

public class PolicySubObject {
    private String name;
    private double sum;
    private RiskType riskType;

    public String getName() {
        return this.name;
    }

    public double getSum() {
        return this.sum;
    }

    public RiskType getRiskType() {
        return this.riskType;
    }
}
