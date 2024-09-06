import java.time.LocalDate;
import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Meeting meet = new Meeting("Bes day meeting", LocalTime.of(16, 0, 0), LocalTime.of(17,0,0));
        Meeting meet2 = new Meeting("Bes day meeting", LocalTime.of(13, 0, 0), LocalTime.of(15,0,0));
        Schedule schedule = new Schedule(LocalDate.of(2024, 3, 19), LocalTime.of(8, 0, 0), LocalTime.of(18,0,0));
        System.out.println(meet.meetingAsString());
        System.out.println("Minutos da reuniao:"+ meet.durationInMinutes());
        schedule.addMeet(meet);
        schedule.addMeet((meet2));
        System.out.println(schedule.scheduleAsString());


    }
}