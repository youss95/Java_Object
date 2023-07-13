package reservation.movie;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import reservation.Money;
import reservation.Screening;
import reservation.Screening_ddd;
import reservation.discount.condition.DiscountCondition;
import reservation.discount.condition.DiscountConditionType;
import reservation.discount.condition.DiscountCondition_ddd;

public class Movie_ddd {
    private Money fee;
    private String title;
    private Duration runningTime;
    private List<DiscountCondition_ddd> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;
	
	public Money calculateMovieFee(Screening_ddd screening) {
		if(isDiscountable(screening)) {
			return fee.minus(calculateDiscountAmount());
		}
		return fee;
	}

    private Money calculateDiscountAmount() {
	switch(movieType) {
		case AMOUNT_DISCOUNT:
		return calculateAmountDiscountedFee();
		case PERCENT_DISCOUNT:
		return calculateAmountPercentFee();
		case NONE_DISCOUNT:
		return calculateNoneDiscountedFee();
	}
	throw new IllegalArgumentException();
    }

	public Money calculateAmountDiscountedFee() {
		
		return discountAmount;
	}

	public Money calculateAmountPercentFee() {
		if (movieType != MovieType.PERCENT_DISCOUNT) {
			throw new IllegalArgumentException();
		}
		return fee.times(discountPercent);
	}

	public Money calculateNoneDiscountedFee() {
		return Money.ZERO;
	}

	public boolean isDiscountable(Screening_ddd screening) {
		return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
	}

	// public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
	// 	for(DiscountCondition_ddd condition : discountConditions) {
	// 		if(condition.getType() == DiscountConditionType.PERIOD) {
	// 			if(condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) {
	// 				return true;
	// 			}
	// 		} else {
	// 			if(condition.isDiscountable(sequence)) {
	// 				return true;
	// 			}
	// 		}
	// 	}
	// 	return false;
	// }

	public Money getFee() {
		return this.fee;
	}

	public void setFee(Money fee) {
		this.fee = fee;
	}

	public List<DiscountCondition_ddd> getDiscountConditions() {
		return this.discountConditions;
	}

	public void setDiscountConditions(List<DiscountCondition_ddd> discountConditions) {
		this.discountConditions = discountConditions;
	}

	public MovieType getMovieType() {
		return this.movieType;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	public Money getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(Money discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getDiscountPercent() {
		return this.discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}


}
