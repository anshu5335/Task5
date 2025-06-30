// BankSimulation.java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BankSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bank Account Simulator!");

        // Create an account
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String accHolderName = scanner.nextLine();
        System.out.print("Enter initial balance: ₹"); // Changed from $
        double initialBal = scanner.nextDouble();

        Account myAccount = new Account(accNum, accHolderName, initialBal);
        System.out.println("\nAccount created successfully for " + myAccount.getAccountHolderName() +
                           " (Account No: " + myAccount.getAccountNumber() + ")");

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: "); // Changed from $
                    double depositAmount = scanner.nextDouble();
                    myAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: "); // Changed from $
                    double withdrawAmount = scanner.nextDouble();
                    myAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: " + String.format("%.2f", myAccount.getBalance())); // Changed from $
                    break;
                case 4:
                    myAccount.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using the Bank Account Simulator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}