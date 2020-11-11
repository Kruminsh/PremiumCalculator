package com.insurance.PremiumCalculator.model;

public class PolicySubObject {
    private String name;
    private double sum;
    private RiskType riskType;

    public PolicySubObject(String name, double sum, RiskType riskType) {
        this.name = name;
        this.sum = sum;
        this.riskType = riskType;
    }

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
