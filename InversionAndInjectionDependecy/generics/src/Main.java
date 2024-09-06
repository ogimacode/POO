import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// como fazer um metado generico:
//    public <T> void blabla(T t){
//        System.out.println(t);
//    }
public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        Repository<String, Employee> repository = new FakeEmployeeRepository();

        boolean exit = false;
        int option;
        while (!exit){
            System.out.println("""
                       =====================================
                       = Escolha uma opção:                =
                       = 1. para adicionar funcionario     =
                       = 2. para achar funcionario         =
                       = 3. Sair                           =
                       =====================================
                       Digite a opção:
                    """);
            option = scanner.nextInt();

            switch (option){
                case 1 -> Contratar(scanner, repository);
                case 2 -> AcharFuncionario(scanner, repository);
                case 3 -> exit = true;
            }
        }
    }

    private static void Contratar(Scanner scanner, Repository<String, Employee> repository) {
        System.out.print("ID do funcionário: ");
        String id = scanner.nextLine();
        System.out.print("Nome do funcionário: ");
        String name = scanner.nextLine();
        System.out.print("Cargo do funcionário: ");
        String jobTitle = scanner.nextLine();
        System.out.print("Salário do funcionário: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Data de contratação (yyyy-mm-dd): ");
        String dateOfEmployment = scanner.nextLine();
        Employee newEmployee = new Employee(id, name, jobTitle, salary, LocalDate.parse(dateOfEmployment));
        repository.register(newEmployee);
    }

    private static void AcharFuncionario(Scanner scanner, Repository<String, Employee> repository)  {
        System.out.println("Digite o id do funcionario:");
        String id = scanner.nextLine();
        System.out.println(repository.findById(id));
    }
}