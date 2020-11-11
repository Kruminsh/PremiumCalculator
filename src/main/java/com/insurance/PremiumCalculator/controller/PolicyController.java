package com.insurance.PremiumCalculator.controller;

import com.insurance.PremiumCalculator.model.Policy;
import com.insurance.PremiumCalculator.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api")
@RestController
public class PolicyController {

    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) { this.policyService = policyService; }

    @PostMapping("/getPremium")
    public double getPremium(@RequestBody Policy policy) {
        return policyService.calculatePremium(policy);
    }
}
