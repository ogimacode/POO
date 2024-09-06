import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Company {
    private final String companyName;

    private List<Employee> employeesList = new ArrayList<>();

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public void hire(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment){
        Employee newEmployee = new Employee(id, name, jobTitle, salary, dateOfEmployment);
        employeesList.add(newEmployee);
    }
    public void fire(String idEmployee){
        if (!employeesList.removeIf(employee -> employee.getId().equals(idEmployee))) throw new NoSuchElementException("The user does not exist");
    }

    public List<Employee> getEmployeesList() {
        if (employeesList.isEmpty()) throw new NoSuchElementException("there are no employees");
        return employeesList;
    }
    public List<Employee> getEmployeesList(String jobTitle) {
        if (employeesList.stream().noneMatch(employee -> employee.getJobTitle().equals(jobTitle))) throw new NoSuchElementException("There are no employees with this job title");
        return employeesList.stream()
                .filter(employee -> employee.getJobTitle().equals(jobTitle)).toList();
    }

    public void pay(String idEmployee){
        employeesList.stream()
                .filter(e -> e.getId().equals(idEmployee))
                .peek(employee -> employee.createPaycheck(LocalDate.now()))
                .findFirst().orElseThrow(() -> new NoSuchElementException("This Employee do not exists"));
    }
    public void increseSalary(String idEmployee, double newSalary){
        employeesList.stream()
                .filter(employee -> employee.getId().equals(idEmployee))
                .peek(employee -> employee.setSalary(newSalary))
                .findFirst().orElseThrow(()-> new NoSuchElementException("This Employee do not exists"));
    }
    public double avarageSalary(String jobTitle){
        return employeesList.stream().filter(employee -> employee.getJobTitle().equals(jobTitle))
                .mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public void printPaychecks() {
        for (Employee employee : employeesList) {
            System.out.println(STR."Employee Name: \{employee.getName()}");
            System.out.println("Paychecks:");
            System.out.println(employee.getPaychecks());
        }
    }
    @Override
    public String toString() {
        return STR."Company{companyName='\{companyName}\{'\''}, employeesList=\{employeesList}\{'}'}";
    }
}
