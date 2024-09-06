import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static java.lang.StringTemplate.STR;

public class Employee {
    private final String id;
    private String name;
    private String jobTitle;
    private double salary;
    private final LocalDate dateOfEmployment;
    private final List<Paycheck> paychecks;

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        setName(name);
        setJobTitle(jobTitle);
        setSalary(salary);
        this.dateOfEmployment = dateOfEmployment;
        paychecks = new ArrayList<>();
    }


    public void createPaycheck(LocalDate payday){
        paychecks.add(new Paycheck(payday, salary));
    }
    public void removePaycheck(Paycheck paycheck){
        paychecks.remove(paycheck);
    }
    public Iterator<Paycheck> iteratorPaychecks(){
        return paychecks.iterator();
    }

    @Override
    public String toString() {
        return STR."Employee{id='\{id}\{'\''}, name='\{name}\{'\''}, jobTitle='\{jobTitle}\{'\''}, salary=\{salary}, dateOfEmployment=\{dateOfEmployment}\{'}'}";
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

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public List<Paycheck> getPaychecks() {
        return paychecks;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
