import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CompanyRepository repository = new InMemoryRepository();
        Company company = new Company("BES Company", repository);
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    ==================================
                    Escolha uma opção:
                    1. Contratar funcionário
                    2. Demitir funcionário
                    3. Pagar funcionário
                    4. Aumentar salário
                    5. Calcular salário médio
                    6. Listar funcionários
                    7. Listar funcionários por cargo
                    8. Salario Medio por data
                    0. Sair
                    ==================================
                    """);
            System.out.print("Opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            try{
            switch (choice) {
                case 1 -> contratar(scanner, company);
                case 2 -> demitir(scanner, company);
                case 3 -> pagar(scanner, company);
                case 4 -> AumentarSalario(scanner, company);
                case 5 -> calcularSalarioMedio(scanner, company);
                case 6 -> listarFuncionarios(company);
                case 7 -> listarFuncionarioPorCargo(scanner, company);
                case 8 -> salarioMedioPorPeriodo(scanner, company);
                case 0 -> exit = true;
                default -> System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        scanner.close();

    }

    private static void salarioMedioPorPeriodo(Scanner scanner, Company company) {
        System.out.println("Digite a data inicial (yyyy-mm-dd): ");
        String dataInicial = scanner.nextLine();
        System.out.println("Digite a data final (yyyy-mm-dd): ");
        String dataFinal = scanner.nextLine();
        System.out.println(company.averageSalary(LocalDate.parse(dataInicial), LocalDate.parse(dataFinal)));
    }

    private static void listarFuncionarioPorCargo(Scanner scanner, Company company) {
        System.out.println("Digite o cargo para listar os funcionários: ");
       String jobTitleForListing = scanner.nextLine();
        System.out.println(company.getEmployeesList(jobTitleForListing));
    }

    private static void listarFuncionarios(Company company) {
        System.out.println(company.getEmployeesList());
    }

    private static void calcularSalarioMedio(Scanner scanner, Company company) {
        System.out.print("Cargo para calcular salário médio: ");
        String jobTitleForAverage = scanner.nextLine();
        double averageSalary = company.averageSalary(jobTitleForAverage);
        System.out.println(STR."Salário médio para \{jobTitleForAverage}: \{averageSalary}");
    }

    private static void AumentarSalario(Scanner scanner, Company company) {
//        System.out.print("ID do funcionário a aumentar o salário: ");
//        String idToIncreaseSalary = scanner.nextLine();

        System.out.print("Novo salário: ");
        double newSalary = scanner.nextDouble();
        scanner.nextLine();
        company.increaseSalary(null, newSalary);
    }

    private static void pagar(Scanner scanner, Company company) {
        System.out.print("ID do funcionário a pagar: ");
        String idToPay = scanner.nextLine();
        company.pay(idToPay);
    }

    private static void demitir(Scanner scanner, Company company) {
        System.out.print("ID do funcionário a demitir: ");
        String idToFire = scanner.nextLine();
        company.fire(idToFire);
    }

    private static void contratar(Scanner scanner, Company company) {
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
        company.hire(id, name, jobTitle, salary, LocalDate.parse(dateOfEmployment));
    }
}