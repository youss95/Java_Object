package phone.billing.s4;


import phone.money.Money;

import java.time.Duration;

import phone.billing.s4.Call;
public class NightlyDiscountPhone extends Phone{
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        super(regularAmount,seconds);
        this.nightlyAmount = nightlyAmount;
    }

    //10 시이전은 phone 재사용
    @Override
    public Money calculateFee() {
        Money result = super.calculateFee();
        Money nightlyFee = Money.ZERO;

        for(Call call: getCalls()) {
            if(call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                nightlyFee = nightlyFee.plus(getAmount().minus(nightlyAmount).times(
                    call.getDuration().getSeconds()/getSeconds().getSeconds()
                ));
            }
        }
        return result.minus(nightlyFee);
    }
}
