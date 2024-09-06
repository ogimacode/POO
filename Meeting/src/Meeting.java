import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Meeting {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;

    public Meeting(String description, LocalTime startTime, LocalTime endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long durationInMinutes(){
        return Duration.between(startTime, endTime).toMinutes();
    }

    public String meetingAsString() {
        return "Meeting{" +
                "description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
