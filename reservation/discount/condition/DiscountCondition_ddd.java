package reservation.discount.condition;

import java.time.DayOfWeek;
import java.time.LocalTime;

import reservation.Screening_ddd;

public class DiscountCondition_ddd {
    private DiscountConditionType type;

    private int sequence;

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

	public DiscountConditionType getType() {
		return this.type;
	}
	//isDiscountable 속성 변경 하면 다른 클래스에서도 변경해야 된다.
	public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
		if(type != DiscountConditionType.PERIOD) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public boolean isDiscountable(int sequence) {
		if(type != DiscountConditionType.SEQUENCE) {
			throw new IllegalArgumentException();
		}
		return this.sequence == sequence;
	}

	public boolean isSatisfiedBy(Screening_ddd screening_ddd) {
		if(type == DiscountConditionType.PERIOD) {
			return isSatisfiedByPeriod();
		}
		return isSatisfiedBySequence();
	}

	private boolean isSatisfiedByPeriod() {
		return true;
	}

	private boolean isSatisfiedBySequence() {
		return true;
	}

	public void setType(DiscountConditionType type) {
		this.type = type;
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public DayOfWeek getDayOfWeek() {
		return this.dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getStartTime() {
		return this.startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return this.endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

}
