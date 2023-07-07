package reservation.discount.policy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import reservation.Money;
import reservation.Screening;
import reservation.discount.condition.DiscountCondition;

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();
    // .할인 정책은 1개 조건은 여러개
    public DiscountPolicy(DiscountCondition ...condition) {
        this.conditions = Arrays.asList(condition);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if(each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }
    // 실제 요금 정산
    abstract protected Money getDiscountAmount(Screening screening);
}
