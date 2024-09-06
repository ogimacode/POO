import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Mario", "Mecanico", LocalDate.now(), 3500);
        PerHourEmployee perHourEmployee = new PerHourEmployee("João", "Eletricista", LocalDate.now(), 100, 160);

        System.out.println(fullTimeEmployee.toString());
        System.out.println(perHourEmployee.toString());
    }
}