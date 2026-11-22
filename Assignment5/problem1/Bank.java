/**
 * File: Bank.java
 * Description: Opens two sample accounts and shows what happens to their balances.
 * Date: 11/19/26
 * @author Tyler Bolander
 */

import java.util.ArrayList;

public class Bank {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<Branch> branches = new ArrayList<>();
        Branch chicago = new Branch("Chicago");
        Branch evanston = new Branch("Evanston");
        branches.add(chicago);
        branches.add(evanston);

        Customer shop = new CommercialCustomer("IGear", "270 Lakewood Ave",
                "(812) 684-2736", 710, "Joe Green", "(812) 462-8519");
        CheckingAccount checking =
                new CheckingAccount(201, 400, shop, chicago, "Duplicate", 100);
        accounts.add(checking);
        displayCustomer(shop, accounts);
        checking.makeDeposit(100);
        displayCustomer(shop, accounts);

        Customer reader = new PersonalCustomer("John Doe", "819 Terrace Dr",
                "(812) 234-5678", "(812) 218-1287", "(812) 495-1738");
        SavingsAccount savings = new SavingsAccount(202, 100, reader, evanston, 10);
        accounts.add(savings);
        displayCustomer(reader, accounts);
        savings.makeDeposit(100);
        double interest = savings.calculateInterest();
        // Post the interest as a deposit after it's calculated
        savings.makeDeposit(interest);
        System.out.printf("Interest credited: $%.2f%n", interest);
        displayCustomer(reader, accounts);

        if (!checking.makeWithdrawal(450)) {
            System.out.println("Withdrawal was declined: the account must meet the minimum balance.");
        }
        if (checking.makeWithdrawal(50)) {
            System.out.printf("Checking balance after a $50 withdrawal is: $%.2f%n",
                    checking.getBalance());
        }

        for (Branch branch : branches) {
            System.out.println("\nAccounts at " + branch + ":");
            for (Account account : accounts) {
                if (branch.equals(account.getBranch())) {
                    System.out.println(account);
                }
            }
        }
    }

    private static void displayCustomer(Customer customer, ArrayList<Account> accounts) {
        System.out.println("\n" + customer);
        for (Account account : accounts) {
            if (customer.equals(account.getCustomer())) {
                System.out.println(account);
            }
        }
    }
}
