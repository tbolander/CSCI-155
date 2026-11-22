/**
 * File: CheckingAccount.java
 * Description: Checks the minimum balance before a withdrawal can be allowed.
 * Date: 11/20/26
 * @author Tyler Bolander
 */

public class CheckingAccount extends Account {
    private String checkStyle;
    private double minimumBalance;

    public CheckingAccount(int accountNumber, double balance, Customer customer, Branch branch, String checkStyle, double minimumBalance) {
        super(accountNumber, balance, customer, branch);
        this.checkStyle = checkStyle;
        this.minimumBalance = minimumBalance;
    }

    public String getCheckStyle() {
        return checkStyle;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    @Override
    public boolean makeWithdrawal(double amount) {
        if (amount <= 0 || getBalance() - amount < minimumBalance) {
            return false;
        }
        return super.makeWithdrawal(amount);
    }

    @Override
    public String toString() {
        return "Checking: " + super.toString() + String.format(
                "\nChecks: %s, minimum balance $%.2f", checkStyle, minimumBalance);
    }
}
