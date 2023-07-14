package phone.billing.synthesis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import phone.billing.s1.Call;
import phone.money.Money;

public class Phone {
    /*
     * 합성 객체를 인터페이스로 설정하고 런타임 시점에 필요한 객체를 설정
     * Phone phone = new Phone(new RegularPolicy())
     */
    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }
}
