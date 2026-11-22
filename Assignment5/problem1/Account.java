/**
 * File: Account.java
 * Description: Holds the balance and the information shared by checking and savings.
 * Date: 11/19/26
 * @author Tyler Bolander
 */

import java.time.LocalDate;

public abstract class Account {
    private int accountNumber;
    private double balance;
    private Customer customer;
    private Branch branch;
    private LocalDate dateOpened = LocalDate.now();

    public Account(int accountNumber, double balance, Customer customer, Branch branch) {
        if (customer == null) {
            throw new IllegalArgumentException("Missing account customer!");
        }
        if (branch == null) {
            throw new IllegalArgumentException("Missing servicing branch!");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
        this.branch = branch;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Branch getBranch() {
        return branch;
    }

    public void makeDeposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean makeWithdrawal(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    @Override
    public String toString() {
        return "Account " + accountNumber + " at " + branch + ", opened " + dateOpened
                + ", balance " + String.format("$%.2f", balance);
    }
}
