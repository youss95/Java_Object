package phone.billing.synthesis;

import phone.money.Money;

public class TaxablePolicy extends AdditionalRatePolicy{
    private double taxRate;

    public TaxablePolicy(double taxRate, RatePolicy ratePolicy) {
        super(ratePolicy);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}
