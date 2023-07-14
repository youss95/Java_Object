package phone.billing.synthesis;

import phone.money.Money;

public abstract class BasicRatePolicy implements RatePolicy{
    /*
     *  중복 코드를 포함하는 기본 정책
     * 
     */
    @Override
    public Money calculateFee(Phone phone) {
        Money result = Money.ZERO;

        for(Call call: phone.getCalls()) {
            result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected abstract Money calculateCallFee(Call call);
}
