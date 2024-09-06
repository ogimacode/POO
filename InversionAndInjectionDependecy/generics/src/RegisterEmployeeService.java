public class RegisterEmployeeService {
    private final Employee[] listEmployee;
    private int countEmployee;

    public RegisterEmployeeService(Employee[] listEmployee) {
        this.listEmployee = listEmployee;
    }


    public void register(Employee newEmployee){
        listEmployee[countEmployee++] = newEmployee;
    }
}
