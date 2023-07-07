package reservation.discount.policy;

import reservation.Money;
import reservation.Screening;

public class NonDiscountPolicy extends DiscountPolicy{
    
    @Override
    protected Money getDiscountAmount(Screening screening) {
        // TODO Auto-generated method stub
        return Money.ZERO;
    }
}
