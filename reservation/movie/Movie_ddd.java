package reservation.movie;

import java.time.Duration;
import java.util.List;

import reservation.Money;
import reservation.discount.condition.DiscountCondition;
import reservation.discount.condition.DiscountCondition_ddd;

public class Movie_ddd {
    private Money fee;
    private String title;
    private Duration runningTime;
    private List<DiscountCondition_ddd> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

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
