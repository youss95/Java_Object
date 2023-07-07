package reservation.discount.policy;

import reservation.Money;
import reservation.Screening;
import reservation.discount.condition.DiscountCondition;

public class PercentDiscountPolicy extends DiscountPolicy{
    
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition ...conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        // TODO Auto-generated method stub
        return screening.getMovieFee().times(percent);
    }

}
