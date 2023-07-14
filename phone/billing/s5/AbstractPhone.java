package phone.billing.s5;

import java.util.ArrayList;
import java.util.List;

import phone.billing.s1.Call;
import phone.money.Money;

public abstract class AbstractPhone {
private List<Call> calls = new ArrayList<>();

public Money calculateFee() {
    Money  result = Money.ZERO;

    for(Call call: calls) {
        result = result.plus(calculateCallFee(call));
    }

    return result;
}

abstract protected Money calculateCallFee(Call call);
}
