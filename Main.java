import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FinanceManager manager = new FinanceManager();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Sistema de Gestão Financeira ---");
            System.out.println("1. Adicionar entrada");
            System.out.println("2. Adicionar saída");
            System.out.println("3. Ver saldo");
            System.out.println("4. Listar transações");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (option) {
                case 1, 2 -> {
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();
                    System.out.print("Valor: R$ ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // limpar buffer
                    String type = (option == 1) ? "entrada" : "saida";
                    manager.addTransaction(new Transaction(desc, amount, LocalDate.now(), type));
                    System.out.println("Transação adicionada com sucesso!");
                }
                case 3 -> {
                    System.out.printf("Saldo atual: R$ %.2f%n", manager.calculateBalance());
                }
                case 4 -> {
                    System.out.println("Transações registradas:");
                    manager.listTransactions();
                }
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (option != 0);

        scanner.close();
    }
}
