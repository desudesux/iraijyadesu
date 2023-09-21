package iraijyadesu38a;

import java.util.Date;

public class Transaction {
    private Date date;
    private String description;
    private double amount;
    private String senderAccountNumber; // Add sender account number
    private String recipientAccountNumber; // Add recipient account number

    public Transaction(String description, double amount, String senderAccountNumber, String recipientAccountNumber) {
        this.date = new Date();
        this.description = description;
        this.amount = amount;
        this.senderAccountNumber = senderAccountNumber;
        this.recipientAccountNumber = recipientAccountNumber;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public String getRecipientAccountNumber() {
        return recipientAccountNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Description: " + description + ", Amount: $" + amount;
    }

    public String getAccountHolder() {
        return null;
    }
}
