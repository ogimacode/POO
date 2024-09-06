import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class PaycheckServices{
    private final Map<String, Employee> employeeMap;

    public PaycheckServices(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public void pay(String idEmployee){
        Objects.requireNonNull(idEmployee, "This Employee ID cannot be null");
        employeeMap.values().stream()
                .filter(employee -> employee.getId().equals(idEmployee))
                .forEach(employee -> employee.createPaycheck(LocalDate.now()));
    }
}
