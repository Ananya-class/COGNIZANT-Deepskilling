
import java.util.Map;

public class FinancialForecaster {

    public static double forecastRecursive(double initialValue, double[] rates, int year) {
        if (year == 0) {
            return initialValue;
        }
        double previousValue = forecastRecursive(initialValue, rates, year - 1);
        double currentRate = rates[(year - 1) % rates.length];
        return previousValue * (1 + currentRate);
    }

    public static double forecastOptimized(double initialValue, double[] rates, int year, Map<Integer, Double> memo) {
        if (year == 0) {
            return initialValue;
        }
        if (memo.containsKey(year)) {
            return memo.get(year);
        }
        double previousValue = forecastOptimized(initialValue, rates, year - 1, memo);
        double currentRate = rates[(year - 1) % rates.length];
        double currentValue = previousValue * (1 + currentRate);
        memo.put(year, currentValue);
        return currentValue;
    }
}
