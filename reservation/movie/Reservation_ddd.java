package reservation.movie;

import reservation.Money;
import reservation.Screening;
import reservation.Screening_ddd;
import reservation.customer.Customer;

public class Reservation_ddd {
    private Customer customer;
    private Screening_ddd screening;
    private Money fee;
    private int audienceCount;

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Screening getScreening() {
		return this.screening;
	}

	public void setScreening(Screening screening) {
		this.screening = screening;
	}

	public Money getFee() {
		return this.fee;
	}

	public void setFee(Money fee) {
		this.fee = fee;
	}

	public int getAudienceCount() {
		return this.audienceCount;
	}

	public void setAudienceCount(int audienceCount) {
		this.audienceCount = audienceCount;
	}


    public Reservation_ddd(Customer customer, Screening_ddd screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }


}
