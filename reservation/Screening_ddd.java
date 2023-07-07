package reservation;

import java.time.LocalDateTime;

import reservation.movie.Movie_ddd;

public class Screening_ddd {
    private Movie_ddd movie;
    private int sequence;
    private LocalDateTime whenScreened;

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
