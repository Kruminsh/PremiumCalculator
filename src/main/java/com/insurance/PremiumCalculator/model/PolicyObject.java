package com.insurance.PremiumCalculator.model;

import java.util.List;

public class PolicyObject {

    private String name;
    private List<PolicySubObject> subObjects;

    public PolicyObject(String name, List<PolicySubObject> subObjects) {
        this.name = name;
        this.subObjects = subObjects;
    }
    public String getName() {
        return this.name;
    }

    public List<PolicySubObject> getSubObjects() {
        return this.subObjects;
    }
}
