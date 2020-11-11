package com.insurance.PremiumCalculator.model;

import java.util.Map;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class PremiumCalculator {

    public static double calculate(@NotNull Policy policy) {
        Map<RiskType, Double> amountsByRisk = policy.getPolicyObjects().stream().flatMap(obj -> obj.getSubObjects().stream())
                .collect(Collectors.groupingBy(subObj -> subObj.getRiskType(), Collectors.summingDouble(subObj -> subObj.getSum())));

        double premium = 0;
        for (Map.Entry<RiskType, Double> riskAmount : amountsByRisk.entrySet()) {
            RiskType riskType = riskAmount.getKey();
            double sum = riskAmount.getValue();
            premium += sum * riskType.getCoefficient(sum);
        }

        return Math.round(premium * 100) / 100.0;
    }

}
