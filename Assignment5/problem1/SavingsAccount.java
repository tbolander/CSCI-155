/**
 * File: SavingsAccount.java
 * Description: Interest is determined using the current savings balance.
 * Date: 11/20/26
 * @author Tyler Bolander
 */

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountNumber, double balance, Customer customer, Branch branch, double interestRate) {
        super(accountNumber, balance, customer, branch);
        this.interestRate = interestRate;
    }

    /** A rate of 10 means ten percent. */
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "Savings: " + super.toString() + ", interest rate " + interestRate + "%";
    }
}
