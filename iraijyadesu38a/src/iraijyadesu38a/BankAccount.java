package iraijyadesu38a;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<Transaction> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        Transaction depositTransaction = new Transaction("Deposit", amount, accountNumber, accountNumber);
        addTransaction(depositTransaction);
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            Transaction withdrawalTransaction = new Transaction("Withdrawal", -amount, accountNumber, accountNumber);
            addTransaction(withdrawalTransaction);
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History for Account: " + accountNumber);

        System.out.println("Deposits and Withdrawals:");
        for (Transaction transaction : transactionHistory) {
            if (transaction.getAmount() != 0 && !transaction.getDescription().startsWith("Fund transfer")) {
                System.out.println(transaction.toString());
            }
        }

        System.out.println("\nFund Transfers:");
        for (Transaction transaction : transactionHistory) {
            if (transaction.getDescription().startsWith("Fund transfer")) {
                System.out.println(transaction.toString());
            }
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
        if (transaction.getAmount() > 0 && !accountNumber.equals(transaction.getRecipientAccountNumber())) {
            transaction.setDescription("Fund transfer from " + transaction.getSenderAccountNumber());
        }
    }
}
