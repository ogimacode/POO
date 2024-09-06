import java.time.LocalDate;
import java.util.Objects;

public class Paycheck {
    private final LocalDate payday;
    private final double salary;

    public Paycheck(LocalDate payday, double salary) {
        this.payday = payday;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return STR."Paycheck{payday=\{payday}, salary=\{salary}\{'}'}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(payday, salary);
    }
    public LocalDate getPayday() {
        return payday;
    }

    public double getSalary() {
        return salary;
    }
}
