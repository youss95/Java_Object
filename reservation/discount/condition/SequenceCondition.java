package reservation.discount.condition;

import reservation.Screening;

public class SequenceCondition implements DiscountCondition{
    private int sequence;
    // 순번 조건
    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        // TODO Auto-generated method stub
        return screening.isSequence(sequence);
    }
}
