package reservation.movie;

import reservation.Money;
import reservation.Screening;
import reservation.Screening_ddd;
import reservation.customer.Customer;
import reservation.discount.condition.DiscountCondition;
import reservation.discount.condition.DiscountConditionType;
import reservation.discount.condition.DiscountCondition_ddd;

public class ReservationAgency {
    // 영화 예매 절차
    public Reservation_ddd reserve(Screening_ddd screening, Customer customer, int audienceCount) {
        Movie_ddd movie = screening.getMovie();

    boolean discountable = false;
    for(DiscountCondition_ddd condition : movie.getDiscountConditions()) {
        if(condition.getType() == DiscountConditionType.PERIOD) {
            discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek());
        } else {
            discountable = condition.getSequence() == screening.getSequence();
        }

        if(discountable) {
            break;
        }
    }

    Money fee;
    if(discountable) {
        Money discountAmount = Money.ZERO;
        switch(movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                discountAmount = movie.getDiscountAmount();
                break;
            case PERCENT_DISCOUNT:
                discountAmount = movie.getFee().times(movie.getDiscountPercent());
                break;
            case NONE_DISCOUNT:
                discountAmount = Money.ZERO;
                break;
        }
        // getFee 리턴 타입이 변경된다면?
        fee = movie.getFee().minus(discountAmount);
    } else {
        fee = movie.getFee();
    }

    return new Reservation_ddd(customer, screening, fee, audienceCount);
    }
}
