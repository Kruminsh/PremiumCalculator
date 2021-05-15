package com.insurance.PremiumCalculator.service;

import com.insurance.PremiumCalculator.model.Policy;
import com.insurance.PremiumCalculator.model.PremiumCalculator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

    public double calculatePremium(Policy policy) {
        return PremiumCalculator.calculate(policy);
    }
}
