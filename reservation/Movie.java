package reservation;

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
    // 비율할인/ 금액할인
    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.caculateDiscountAmount(screening));
    }
    
}
