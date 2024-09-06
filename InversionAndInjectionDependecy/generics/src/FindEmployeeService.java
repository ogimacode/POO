public class FindEmployeeService {
    private final Employee[] listEmployee;

    public FindEmployeeService(Employee[] listEmployee) {
        this.listEmployee = listEmployee;
    }

    public Employee findById(String id) throws EntityNotFoundException {
        for (Employee employee : listEmployee){
            if (employee.getId().equals(id)){
                return employee;
            }
        }
        throw new EntityNotFoundException("The user does not exist");
    }
}
