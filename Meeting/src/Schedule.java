import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Schedule {
    private LocalDate day;
    private LocalTime startTime;
    private LocalTime endTime;

    private Meeting meetings;

    private int numMeeting = 0;
    private  int maxMeeting = 5;
    private final Meeting[] scheduledMeetings = new Meeting[maxMeeting];

    public Schedule(LocalDate day, LocalTime startTime, LocalTime endTime){
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void addMeet(Meeting meeting){
        if (numMeeting > maxMeeting ){System.out.println("Maximum number of meetings reached");}
        else {scheduledMeetings[numMeeting++] = meeting;}
    }
    public void removeMeet(Meeting meeting){
        int index = -1;
        for (int i = 0; i < numMeeting; i++) {
            if (scheduledMeetings[i].equals(meeting)){
                index = i;
            }
        }
        if (index != -1){
            for (int i = index; i < numMeeting -1; i++) {
                scheduledMeetings[i] = scheduledMeetings[i + 1];
            }
            scheduledMeetings[numMeeting - 1] = null;
            numMeeting--;
        }
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    //    public double percentageSpentInMeetings(){
//        double totalMinutes = 0;
//        for (Meeting meeting : scheduledMeetings){
//            totalMinutes += meeting.durationInMinutes();
//        }
//        return
//    }

    public String scheduleAsString(){
            return "Schedule{" +
                    "day=" + day +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", meetings=" + meetings +
            ", numMeeting=" + numMeeting +
            ", maxMeeting=" + maxMeeting +
            ", scheduledMeetings=" + Arrays.toString(scheduledMeetings) +
            '}';

    }

}
