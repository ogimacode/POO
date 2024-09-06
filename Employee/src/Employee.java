import java.time.LocalDate;

public sealed abstract class Employee permits FullTimeEmployee, PerHourEmployee {
    private final String name;
    private final String jobTitle;
    private final LocalDate dateOfEmployment;

    public Employee(String name, String jobTitle, LocalDate dateOfEmployment) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
    }

    public abstract double salary();

    @Override
    public String toString() {
        return "Employee{" +
                "name=" + name +
                ", jobTitle=" + jobTitle +
                ", dateOfEmployment=" + dateOfEmployment +
                ", salary=" + salary() +
                '}';
    }

}
