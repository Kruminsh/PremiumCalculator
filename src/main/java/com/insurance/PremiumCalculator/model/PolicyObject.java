package com.insurance.PremiumCalculator.model;

import java.util.List;

public class PolicyObject {

    private String name;
    private List<PolicySubObject> subObjects;

    public String getName() {
        return this.name;
    }

    public List<PolicySubObject> getSubObjects() {
        return this.subObjects;
    }
}
