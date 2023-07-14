package phone.billing.synthesis;

import phone.money.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
