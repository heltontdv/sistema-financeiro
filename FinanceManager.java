import java.util.ArrayList;
import java.util.List;

public class FinanceManager {
    private List<Transaction> transactions;

    public FinanceManager() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public double calculateBalance() {
        double balance = 0.0;
        for (Transaction t : transactions) {
            balance += t.getAmount();
        }
        return balance;
    }

    public void listTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}
