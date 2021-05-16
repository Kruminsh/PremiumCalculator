package com.insurance.PremiumCalculator;

import com.insurance.PremiumCalculator.model.*;
import com.insurance.PremiumCalculator.service.PolicyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RiskTypeCoefficientTests {


	@Test
	void fireTest() {
		// amount > 100.0 ? 0.024f : 0.014f;
		RiskType riskType = RiskType.FIRE;
		assertEquals(0.024f, riskType.getCoefficient(110));
		assertEquals(0.024f, riskType.getCoefficient(100.01));
		assertEquals(0.014f, riskType.getCoefficient(100));
		assertEquals(0.014f, riskType.getCoefficient(99.99));
	}

	@Test
	void theftTest() {
		// amount >= 15.0 ? 0.05f : 0.11f
		RiskType riskType = RiskType.THEFT;
		assertEquals(0.05f, riskType.getCoefficient(20));
		assertEquals(0.05f, riskType.getCoefficient(15));
		assertEquals(0.11f, riskType.getCoefficient(14.99));
		assertEquals(0.11f, riskType.getCoefficient(1));
	}
}
