import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Employee {
    private final String id;
    private String name;
    private String jobTitle;
    private double salary;
    private final LocalDate dateOfEmployment;


    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        setName(name);
        setJobTitle(jobTitle);
        setSalary(salary);
        this.dateOfEmployment = dateOfEmployment;
    }


    public double getYearsOfService(){
        return dateOfEmployment.getYear();
    }

    public String getId() {
        return id;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }
}
