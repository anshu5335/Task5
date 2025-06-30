import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        recordTransaction("Account created with initial balance: " + String.format("%.2f", initialBalance));
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            recordTransaction("Deposited: " + String.format("%.2f", amount) + " | New Balance: " + String.format("%.2f", balance));
            System.out.println("Deposit successful. New balance: ₹" + String.format("%.2f", balance));
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                recordTransaction("Withdrew: " + String.format("%.2f", amount) + " | New Balance: " + String.format("%.2f", balance));
                System.out.println("Withdrawal successful. New balance: ₹" + String.format("%.2f", balance));
            } else {
                System.out.println("Insufficient funds. Current balance: " + String.format("%.2f", balance));
                recordTransaction("Attempted withdrawal of " + String.format("%.2f", amount) + " | Insufficient funds.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History for Account " + accountNumber + " ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
        System.out.println("----------------------------------------------");
    }

    private void recordTransaction(String description) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        transactionHistory.add(formatter.format(date) + " - " + description);
    }
}