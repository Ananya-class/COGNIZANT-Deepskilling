
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        double initialInvestment = 10000.0;
        double[] historicalRates = {0.05, 0.07, 0.04, 0.06};
        int targetYears = 10;

        System.out.println("--- Standard Recursive Forecasting ---");
        double standardResult = FinancialForecaster.forecastRecursive(initialInvestment, historicalRates, targetYears);
        System.out.printf("Value after %d years: $%.2f%n", targetYears, standardResult);

        System.out.println("\n--- Optimized Memoized Forecasting ---");
        Map<Integer, Double> cache = new HashMap<>();
        double optimizedResult = FinancialForecaster.forecastOptimized(initialInvestment, historicalRates, targetYears, cache);
        System.out.printf("Value after %d years: $%.2f%n", targetYears, optimizedResult);
    }
}
