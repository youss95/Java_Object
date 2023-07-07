package reservation.discount.policy;

import reservation.Money;
import reservation.Screening;
import reservation.discount.condition.DiscountCondition;

public class AmountDiscountPolicy extends DiscountPolicy{
    
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition ...conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        // TODO Auto-generated method stub
        return discountAmount;
    }
}
