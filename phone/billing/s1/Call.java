package phone.billing.s1;

import java.time.Duration;
import java.time.LocalDateTime;

public class Call {
    private LocalDateTime from;
    private LocalDateTime to;

	public LocalDateTime getFrom() {
		return this.from;
	}

    public Call(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }



    public Duration getDuration() {
        return Duration.between(from, to);
    }
}
