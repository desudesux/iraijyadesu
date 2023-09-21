package iraijyadesu38a;

import java.util.Scanner;

public class FundTransfer {
    public static void transferFunds(Bank bank, Scanner scanner) {
        System.out.print("Enter your account number: ");
        String senderAccountNumber = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String senderPin = scanner.nextLine();
        BankAccount senderAccount = bank.getAccount(senderAccountNumber, senderPin);

        if (senderAccount != null) {
            System.out.print("Enter recipient's account number: ");
            String recipientAccountNumber = scanner.nextLine();
            System.out.print("Enter recipient's PIN: ");
            String recipientPin = scanner.nextLine();

            BankAccount recipientAccount = bank.getAccount(recipientAccountNumber, recipientPin);

            if (recipientAccount != null) {
                System.out.print("Enter the amount to transfer: $");
                double transferAmount = scanner.nextDouble();
                if (senderAccount.getBalance() >= transferAmount) {
                    // Perform the transfer
                    senderAccount.withdraw(transferAmount);
                    recipientAccount.deposit(transferAmount);

                    // Create a transaction for the sender
                    Transaction senderTransaction = new Transaction("Fund transfer to " + recipientAccountNumber, -transferAmount, senderAccountNumber, recipientAccountNumber);

                    // Create a transaction for the recipient
                    Transaction recipientTransaction = new Transaction("Fund transfer from " + senderAccountNumber, transferAmount, senderAccountNumber, recipientAccountNumber);

                    // Add the transactions to the respective accounts
                    senderAccount.addTransaction(senderTransaction);
                    recipientAccount.addTransaction(recipientTransaction);

                    System.out.println("Funds transferred successfully.");
                } else {
                    System.out.println("Insufficient funds for the transfer.");
                }
            } else {
                System.out.println("Recipient's account not found or incorrect PIN.");
            }
        } else {
            System.out.println("Sender's account not found or incorrect PIN.");
        }
    }
}