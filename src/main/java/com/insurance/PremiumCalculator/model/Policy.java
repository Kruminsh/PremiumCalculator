package com.insurance.PremiumCalculator.model;

import java.util.List;

public class Policy {

    private String policyNumber;
    private PolicyStatus policyStatus;
    private List<PolicyObject> policyObjects;

    public String getPolicyNumber() {
        return this.policyNumber;
    }

    public PolicyStatus getPolicyStatus() {
        return this.policyStatus;
    }

    public List<PolicyObject> getPolicyObjects() {
        return this.policyObjects;
    }
}
