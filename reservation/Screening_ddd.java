package reservation;

import java.time.LocalDateTime;

import reservation.customer.Customer;
import reservation.movie.Movie_ddd;
import reservation.movie.Reservation_ddd;

public class Screening_ddd {
    private Movie_ddd movie;
    private int sequence;
    private LocalDateTime whenScreened;
	
	public Reservation_ddd reserve(Customer customer, int audienceCount) {
		return new Reservation_ddd(customer, this, calculateFee(audienceCount), audienceCount);
	}

	public Screening_ddd(Movie_ddd movie, int sequence, LocalDateTime whenScreened) {
		this.movie = movie;
		this.sequence = sequence;
		this.whenScreened = whenScreened;
	}

	private Money calculateFee(int audienceCount) {
		return movie.calculateMovieFee(this).times(audienceCount);
	}

	// movie - discountcondition
	

	public Movie_ddd getMovie() {
		return this.movie;
	}

	public void setMovie(Movie_ddd movie) {
		this.movie = movie;
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public LocalDateTime getWhenScreened() {
		return this.whenScreened;
	}

	public void setWhenScreened(LocalDateTime whenScreened) {
		this.whenScreened = whenScreened;
	}



}
