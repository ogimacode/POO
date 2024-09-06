import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository implements  CompanyRepository{

    private final EmployeeServices employeeServices;
    private final PaycheckServices paycheckServices;
    private Map<String, Employee> employeeMap = new LinkedHashMap<>();

    public InMemoryRepository() {
        employeeServices = new EmployeeServices(employeeMap);
        paycheckServices = new PaycheckServices(employeeMap);
    }

    @Override
    public void hire(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        employeeServices.hire(id, name, jobTitle, salary, dateOfEmployment);
    }

    @Override
    public void fire(String idEmployee) {
        employeeServices.fire(idEmployee);
    }

    @Override
    public List<Employee> getEmployeesList() {
        return employeeServices.getEmployeesList();
    }

    @Override
    public List<Employee> getEmployeesListByJobTitle(String jobTitle) {
        return employeeServices.getEmployeesListByJobTitle(jobTitle);
    }

    @Override
    public void pay(String idEmployee) {
        paycheckServices.pay(idEmployee);
    }

    @Override
    public void increaseSalary(String idEmployee, double newSalary) {
        employeeServices.increaseSalary(idEmployee, newSalary);
    }

    @Override
    public double averageSalary(LocalDate inicialDate, LocalDate finalDate){
        return employeeServices.averageSalary(inicialDate, finalDate);
    }

    @Override
    public double averageSalary(String jobTitle) {
        return employeeServices.averageSalary(jobTitle);
    }
}
