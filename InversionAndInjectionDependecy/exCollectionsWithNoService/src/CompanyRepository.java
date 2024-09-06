import java.time.LocalDate;
import java.util.List;

public interface CompanyRepository {
    void hire(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment);

    void fire(String idEmployee);

    List<Employee> getEmployeesList();
    List<Employee> getEmployeesListByJobTitle(String jobTitle);
    void pay(String idEmployee);
    void increaseSalary(String idEmployee, double newSalary);
    double averageSalary(String jobTitle);
}
