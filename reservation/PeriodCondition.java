package reservation;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition{
    // 기간 조건
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private boolean isSameDay(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek);
    }

    private boolean isTimeBetweenScreeningTime(Screening screening) {
        return startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
            endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        // TODO Auto-generated method stub
        return isSameDay(screening) && isTimeBetweenScreeningTime(screening);
    }
}
