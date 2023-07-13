package reservation.movie;

import reservation.Money;
import reservation.Screening_ddd;
import reservation.customer.Customer;


public class ReservationAgency {
    // 영화 예매 절차
    public Reservation_ddd reserve(Screening_ddd screening, Customer customer, int audienceCount) {
       Money fee = screening.calculateFee(audienceCount);
       return new Reservation_ddd(customer, screening, fee, audienceCount);
    }

}
