package com.insurance.PremiumCalculator;

import com.insurance.PremiumCalculator.model.*;
import com.insurance.PremiumCalculator.service.PolicyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;

@SpringBootTest
class PremiumCalculatorApiTests {

	@Autowired
	private PolicyService policyService;

	@Test
	void OnePolicyObject() {
		// Case 1:
		// Risk type = FIRE, Sum insured = 100.00
		// Risk type = FIRE, Sum insured = 100.00
		// Result should be 2.28
		Policy policyCase1 = new Policy("Policy #1", PolicyStatus.REGISTERED,
				new ArrayList<PolicyObject>() {
					{
						add(new PolicyObject("Object 1", new ArrayList<PolicySubObject>() {
							{
								add(new PolicySubObject("SubObject 1.1", 100.0, RiskType.FIRE));
								add(new PolicySubObject("SubObject 1.2", 8.0, RiskType.THEFT));
							}
						}));
					}
				});
		assertEquals(2.29, policyService.calculatePremium(policyCase1)); //2.28
	}

	@Test
	void MultiplePolicyObjects() {
		// Case 2:
		// Risk type = FIRE, Sum insured = 500.00
		// Risk type = FIRE, Sum insured = 102.51
		// Result should be 17.13
		Policy policyCase2 = new Policy("Policy #2", PolicyStatus.APPROVED,
				new ArrayList<PolicyObject>() {
					{
						add(new PolicyObject("Object 1", new ArrayList<PolicySubObject>() {
							{
								add(new PolicySubObject("SubObject 1.1", 2.51, RiskType.THEFT));
								add(new PolicySubObject("SubObject 1.2", 150.0, RiskType.FIRE));
								add(new PolicySubObject("SubObject 1.3", 59.99, RiskType.THEFT));
							}
						}));

						add(new PolicyObject("Object 2", new ArrayList<PolicySubObject>() {
							{
								add(new PolicySubObject("SubObject 2.1", 199.99, RiskType.FIRE));
							}
						}));

						add(new PolicyObject("Object 3", new ArrayList<PolicySubObject>() {
							{
								add(new PolicySubObject("SubObject 3.1", 40.01, RiskType.THEFT));
								add(new PolicySubObject("SubObject 3.2", 11.0, RiskType.FIRE));
							}
						}));

						add(new PolicyObject("Object 4", new ArrayList<PolicySubObject>() {
							{
								add(new PolicySubObject("SubObject 4.1", 139.1, RiskType.FIRE));
							}
						}));
					}
				});
		assertEquals(17.12, policyService.calculatePremium(policyCase2)); //17.13
	}

	@Test
	void NoPolicyObjects() {
		// Case 3:
		// Policy without policy objects
		// Result should be 0
		Policy policyCase3 = new Policy("Policy #3", PolicyStatus.APPROVED, new ArrayList<PolicyObject>());
		assertEquals(1, policyService.calculatePremium(policyCase3));
	}
}
