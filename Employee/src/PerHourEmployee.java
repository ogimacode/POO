import java.time.LocalDate;

public final class PerHourEmployee extends Employee {
    private final double hourlyRate;
    private final int hoursWorked;

    public PerHourEmployee(String name, String jobTitle, LocalDate dateOfEmployment, double hourlyRate, int hoursWorked) {
        super(name, jobTitle, dateOfEmployment);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double salary() {
        return hourlyRate * hoursWorked;
    }
}
