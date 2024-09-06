import java.time.LocalDate;
import java.util.List;

public class Company {
    private  final String companyName;
    private final CompanyRepository repository;

    public Company(String companyName, CompanyRepository repository) {
        this.companyName = companyName;
        this.repository = repository;
    }

    public void hire(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        repository.hire(id, name, jobTitle, salary, dateOfEmployment);
    }


    public void fire(String idEmployee) {
        repository.fire(idEmployee);
    }


    public List<Employee> getEmployeesList() {
        return repository.getEmployeesList();
    }


    public List<Employee> getEmployeesList(String jobTitle) {
        return repository.getEmployeesListByJobTitle(jobTitle);
    }


    public void pay(String idEmployee) {
        repository.pay(idEmployee);
    }

    public void increaseSalary(String idEmployee, double newSalary) {
        repository.increaseSalary(idEmployee, newSalary);
    }

    public double averageSalary(String jobTitle) {
        return repository.averageSalary(jobTitle);
    }
    public double averageSalary(LocalDate inicialDate, LocalDate finalDate){
        return repository.averageSalary(inicialDate, finalDate);
    }

    @Override
    public String toString() {
        return STR."Company{companyName='\{companyName}\{'\''}, repository=\{repository}\{'}'}";
    }
}
