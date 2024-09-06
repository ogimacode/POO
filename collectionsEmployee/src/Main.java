import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("BES Company");
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("==================================");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Contratar funcionário");
            System.out.println("2. Demitir funcionário");
            System.out.println("3. Pagar funcionário");
            System.out.println("4. Aumentar salário");
            System.out.println("5. Calcular salário médio");
            System.out.println("6. Listar funcionários");
            System.out.println("7. Listar funcionários por cargo");
            System.out.println("8. Conferir Contra-cheques da Empresa");
            System.out.println("9. Sair");
            System.out.println("==================================");
            System.out.print("Opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
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

                    break;
                case 2:
                    System.out.print("ID do funcionário a demitir: ");
                    String idToFire = scanner.nextLine();
                    company.fire(idToFire);
                    break;
                case 3:
                    System.out.print("ID do funcionário a pagar: ");
                    String idToPay = scanner.nextLine();
                    company.pay(idToPay);
                    break;
                case 4:
                    System.out.print("ID do funcionário a aumentar o salário: ");
                    String idToIncreaseSalary = scanner.nextLine();

                    System.out.print("Novo salário: ");
                    double newSalary = scanner.nextDouble();
                    scanner.nextLine();
                    company.increseSalary(idToIncreaseSalary, newSalary);
                    break;
                case 5:
                    System.out.print("Cargo para calcular salário médio: ");
                    String jobTitleForAverage = scanner.nextLine();
                    double averageSalary = company.avarageSalary(jobTitleForAverage);
                    System.out.println(STR."Salário médio para \{jobTitleForAverage}: \{averageSalary}");
                    break;
                case 6:
                    System.out.println(company.getEmployeesList());
                    break;
                case 7:
                    System.out.println("Digite o cargo para listar os funcionários: ");
                    String jobTitleForListing = scanner.nextLine();
                    System.out.println(company.getEmployeesList(jobTitleForListing));
                    break;
                case 8:
                    company.printPaychecks();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
        scanner.close();

    }
}