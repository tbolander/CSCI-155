/**
 * File: Account.java
 * Description: Keep track of an account's balance, deposits, withdrawals, and monthly interest.
 * Date: 10/26/26
 * @author Tyler Bolander
 */

import java.util.Date;

public class Account {

    private int id = 0;
    private double balance = 0;
    // The interest rate is shared by every account.
    private static double annualInterestRate = 0;
    private Date dateCreated;

    /** Creates an account with the default ID and balance. */
    public Account() {
        dateCreated = new Date();
    }

    /** Creates an account with the given ID and starting balance. */
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setId(int id) {
        this.id = id;
    }

    /** Updates the annual percentage rate for all accounts. */
    public static void setAnnualInterestRate(double rate) {
        annualInterestRate = rate;
    }

    /** Divides the percentage by 100, then by 12 to get the monthly rate. */
    public double getMonthlyInterestRate() {
        return annualInterestRate / 100 / 12;
    }

    /** Returns the interest earned for one month at the current balance. */
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    /** Subtracts the requested amount from the balance. */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /** Adds the requested amount to the balance. */
    public void deposit(double amount) {
        balance += amount;
    }
}
