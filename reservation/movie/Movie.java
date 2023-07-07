package reservation.movie;

import java.time.Duration;

import reservation.Money;
import reservation.Screening;
import reservation.discount.policy.DiscountPolicy;

public class Movie {
    private Money fee;
    private String title;
    private Duration runningTime;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return this.fee;
    }

    // 차감된 요금 반환
    // 비율할인 / 금액할인
    public Money calculateMovieFee(Screening screening) {
        // 컴파일시점 discountpolicy, 실행시점 account, percent
        // 받은 객체에 따라 달라진다.
        /**
         * 할인 금액을 결정을 movie가 하게된다.
        if(discountPolicy == null) {
            return fee;
        }
        */
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

   
    
}
