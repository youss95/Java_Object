package reservation;

import java.time.Duration;

import reservation.discount.policy.NonDiscountPolicy;
import reservation.discount.policy.PercentDiscountPolicy;
import reservation.movie.Movie;

public class ex {
     public static void main(String[] args) {
      Movie m1 = new Movie("d",Duration.ofSeconds(1L), Money.wons(1000),new PercentDiscountPolicy(0.1, null));  
      Movie m2 = new Movie("ss",Duration.ofSeconds(100L),Money.wons(1000),new NonDiscountPolicy());
    }
}
