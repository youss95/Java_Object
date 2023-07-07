package reservation.discount.condition;

import reservation.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
