import java.util.Arrays;

public class FakeEmployeeRepository implements Repository<String, Employee> {

    private Employee[] employeesArrays = new Employee[10];

    private final FindEmployeeService findEmployeeService;
    private final RegisterEmployeeService registerEmployeeService;

    public FakeEmployeeRepository() {
        findEmployeeService = new FindEmployeeService(employeesArrays);
        registerEmployeeService = new RegisterEmployeeService(employeesArrays);
    }


    @Override
    public Employee findById(String id)  {
        try {
            return findEmployeeService.findById(id);
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    @Override
    public void register(Employee newEmployee) {
        registerEmployeeService.register(newEmployee);
    }
}
