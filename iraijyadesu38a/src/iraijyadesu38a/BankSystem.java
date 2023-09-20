package iraijyadesu38a;

import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Access Account");
            System.out.println("3. Exit");
            System.out.print("Please select an option (1/2/3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter account holder's name: ");
                    String accountHolder = scanner.nextLine();
                    System.out.print("Enter initial balance: $");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Set a PIN: ");
                    String pin = scanner.nextLine();
                    bank.addAccount(accountNumber, accountHolder, initialBalance, pin);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter PIN: ");
                    pin = scanner.nextLine();
                    BankAccount account = bank.getAccount(accountNumber, pin);
                    if (account != null) {
                        while (true) {
                            System.out.println("\nAccount Menu:");
                            System.out.println("1. Check Balance");
                            System.out.println("2. Deposit");
                            System.out.println("3. Withdraw");
                            System.out.println("4. Back to Main Menu");
                            System.out.print("Please select an option (1/2/3/4): ");
                            int accountChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            switch (accountChoice) {
                                case 1:
                                    account.checkBalance();
                                    break;
                                case 2:
                                    System.out.print("Enter the deposit amount: $");
                                    double depositAmount = scanner.nextDouble();
                                    account.deposit(depositAmount);
                                    break;
                                case 3:
                                    System.out.print("Enter the withdrawal amount: $");
                                    double withdrawalAmount = scanner.nextDouble();
                                    account.withdraw(withdrawalAmount);
                                    break;
                                case 4:
                                    System.out.println("Returning to Main Menu.");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please select a valid option.");
                            }

                            if (accountChoice == 4) {
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using our banking system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
