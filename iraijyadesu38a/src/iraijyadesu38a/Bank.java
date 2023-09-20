package iraijyadesu38a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<String, BankAccount> accounts; // Map to store accounts by account number
    private Map<String, String> userPins; // Map to store user PINs by account number

    public Bank() {
        accounts = new HashMap<>();
        userPins = new HashMap<>();
    }

    public void addAccount(String accountNumber, String accountHolder, double initialBalance, String pin) {
        if (!accounts.containsKey(accountNumber)) {
            BankAccount account = new BankAccount(accountNumber, accountHolder, initialBalance);
            accounts.put(accountNumber, account);
            userPins.put(accountNumber, pin);
            System.out.println("Account created successfully for " + accountHolder);
        } else {
            System.out.println("Account number already exists. Please choose a different account number.");
        }
    }

    public BankAccount getAccount(String accountNumber, String pin) {
        if (accounts.containsKey(accountNumber) && userPins.get(accountNumber).equals(pin)) {
            return accounts.get(accountNumber);
        } else {
            System.out.println("Invalid account number or PIN.");
            return null;
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        // Adding accounts with individual PINs
        bank.addAccount("12345", "John Doe", 1000.0, "1111");
        bank.addAccount("67890", "Jane Smith", 1500.0, "2222");

        // Interacting with accounts
        BankAccount johnsAccount = bank.getAccount("12345", "1111");
        if (johnsAccount != null) {
            johnsAccount.checkBalance();
            johnsAccount.deposit(200.0);
            johnsAccount.checkBalance();
        }

        BankAccount invalidAccount = bank.getAccount("12345", "1234"); // Incorrect PIN

        BankAccount janesAccount = bank.getAccount("67890", "2222");
        if (janesAccount != null) {
            janesAccount.checkBalance();
            janesAccount.withdraw(300.0);
            janesAccount.checkBalance();
        }
    }
}


