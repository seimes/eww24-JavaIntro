package at.technikum.w3resourceOOP.exercise7;

public class Account {
    private String name;
    private String accountNumber;
    private static int accountCount = 0;
    private double balance;
    private double overdraftLimit;

    public Account(String name) {
        this.name = name;
        this.accountNumber = "AT" + accountCount++;
        this.balance = 0;
        this.overdraftLimit = 0;
    }

    public Account(String name, double balance) {
        this.name = name;
        this.accountNumber = "AT" + accountCount++;
        this.balance = balance;
        this.overdraftLimit = 0;
    }

    public Account(String name, double balance, double overdraftLimit) {
        this.name = name;
        this.accountNumber = "AT" + accountCount++;
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void withdraw(double amount) {
        if (amount > (this.balance + this.overdraftLimit)) return;

        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double limit) {
        this.overdraftLimit = limit;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public String getAccountInfo() {
        return "Name: " + name + ", Account Number: " + accountNumber + ", Balance: " + balance;
    }
}
