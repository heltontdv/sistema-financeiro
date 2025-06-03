import java.time.LocalDate;

public class Transaction {
    private String description;
    private double amount;
    private LocalDate date;
    private String type; // "entrada" ou "saida"

    public Transaction(String description, double amount, LocalDate date, String type) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public double getAmount() {
        return type.equalsIgnoreCase("entrada") ? amount : -amount;
    }

    public String toString() {
        return String.format("%s - %s: R$%.2f (%s)", date, description, amount, type);
    }
}
