package phone.billing.s2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import phone.billing.s1.Call;
import phone.money.Money;

public class Phone {
    private Money amount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();
    private Double taxRate;

    public Phone(Money amount, Duration seconds, Double taxRate) {
        this.amount = amount;
        this.seconds = seconds;
        this.taxRate = taxRate;
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
            result = result.plus(amount.times(call.getDuration().getSeconds()/seconds.getSeconds()));
        }

        return result.plus(result.times(taxRate));
    }
}
