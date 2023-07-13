package phone.billing.s3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import phone.billing.s1.Call;
import phone.money.Money;

public class Phone {
    /**
     * 중복 코드 제거, 클래스 합치기
     */
    private static final int LATE_NIGHT_HOUR = 22;
    private Money amount;
    private Money nightlyAmount;
    private Money regularAmount;
    private PhoneType type;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();


    public Phone(Money amount, Duration seconds) {
        this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds);
    }

    public Phone(Money nightlyAmt, Money regularAmt, Duration seconds) {
        this(PhoneType.NIGHTLY,Money.ZERO,nightlyAmt,regularAmt,seconds);
    }

    public Phone(PhoneType type, Money amount, Money nightlyAmount,
                 Money regularAmount, Duration seconds) {
        this.type = type;
        this.amount = amount;
        this.regularAmount = regularAmount;
        this.nightlyAmount = nightlyAmount;
        this.seconds = seconds;
    }

    public void call(Call call) {
        calls.add(call);
    }
    
    public List<Call> getCalls() {
        return this.calls;
    }

    public Money getAmount() {
        return this.amount;
    }
    // 5초당 10초당 요금 부과
    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call: calls) {
            if(type == PhoneType.REGULAR) {
                result = result.plus(amount.times(call.getDuration().getSeconds()/seconds.getSeconds()));
            } else {
                if(call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                    result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                } else {
                    result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                }
            }
        }

        return result;
    }
}
