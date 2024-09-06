import java.time.LocalDate;
import java.util.*;

public class InMemoryRepository implements  CompanyRepository{


    private Map<String, Employee> employeeMap = new LinkedHashMap<>();

    public InMemoryRepository() {
    }

    public void hire(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment){
        Employee newEmployee = new Employee(id, name, jobTitle, salary, dateOfEmployment);
        employeeMap.put(id, newEmployee);
    }
    public void fire(String idEmployee){
        employeeMap.remove(idEmployee);
    }

    public List<Employee> getEmployeesList() {
        return new ArrayList<>(employeeMap.values());
    }
    public List<Employee> getEmployeesListByJobTitle(String jobTitle) {
        Objects.requireNonNull(jobTitle, "This Employee JobTitle cannot be null");
        return new ArrayList<>(employeeMap.values().stream()
                .filter(employee -> employee.getJobTitle().equals(jobTitle)).toList());
    }

    public void increaseSalary(String idEmployee, double newSalary){
        Objects.requireNonNull(idEmployee, "This Employee ID cannot be null");
        employeeMap.values().stream()
                .filter(employee -> employee.getId().equals(idEmployee))
                .forEach(employee -> employee.setSalary(newSalary));
    }
    public double averageSalary(String jobTitle){
        Objects.requireNonNull(jobTitle, "This Employee JobTitle cannot be null");
        return employeeMap.values().stream()
                .filter(employee -> employee.getJobTitle().equals(jobTitle))
                .mapToDouble(Employee::getSalary).average().orElse(0);
    }
    public void pay(String idEmployee){
        Objects.requireNonNull(idEmployee, "This Employee ID cannot be null");
        employeeMap.values().stream()
                .filter(employee -> employee.getId().equals(idEmployee))
                .forEach(employee -> employee.createPaycheck(LocalDate.now()));
    }
}
