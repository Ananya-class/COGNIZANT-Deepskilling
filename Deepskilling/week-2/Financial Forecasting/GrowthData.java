
public class GrowthData {

    private double initialValue;
    private double[] annualGrowthRates;

    public GrowthData(double initialValue, double[] annualGrowthRates) {
        this.initialValue = initialValue;
        this.annualGrowthRates = annualGrowthRates;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public double[] getAnnualGrowthRates() {
        return annualGrowthRates;
    }
}
