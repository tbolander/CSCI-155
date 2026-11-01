/**
 * File: UseAccount.java
 * Description: Withdrawal and deposit, then prints the balance, monthly interest, and date created.
 * Date: 10/27/26
 * @author Tyler Bolander
 */

public class UseAccount {

    public static void main(String[] args) {
        Account sampleAccount = new Account(1122, 20000);
        Account.setAnnualInterestRate(4.5);

        sampleAccount.withdraw(2500);
        sampleAccount.deposit(3000);

        System.out.println("Account ID: " + sampleAccount.getId());
        System.out.printf("Balance: $%.2f%n", sampleAccount.getBalance());
        System.out.printf("Monthly interest: $%.2f%n", sampleAccount.getMonthlyInterest());
        System.out.println("Created: " + sampleAccount.getDateCreated());
    }
}
