/**
 * File: UserAccounts.java
 * Description: Let the user choose an account, check its balance, and deposit/withdraw money.
 * Date: 11/01/26
 * @author Tyler Bolander
 */

import java.util.Scanner;

public class UserAccounts {

    private Account[] accounts = new Account[8];
    private Scanner input = new Scanner(System.in);

    /** Creates accounts 0 through 7, each starting with $50 */
    public UserAccounts() {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 50);
        }
    }

    public static void main(String[] args) {
        UserAccounts accountSystem = new UserAccounts();
        accountSystem.start();
    }

    /** Keeps asking for an account ID after each user leaves the menu */
    public void start() {
        while (true) {
            int id = readInt("\nEnter an account ID (0-7): ");
            if (id >= 0 && id < accounts.length) {
                showMenu(accounts[id]);
            } else {
                System.out.println("That ID was not found. Enter a number from 0 to 7.");
            }
        }
    }

    /** Shows the selected account's menu. Option 4 goes back to choosing an ID */
    private void showMenu(Account account) {
        boolean finished = false;

        while (!finished) {
            System.out.println("\nAccount " + account.getId() + " menu");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Return to account selection");
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    System.out.printf("Balance: $%.2f%n", account.getBalance());
                    break;
                case 2:
                    double withdrawal = readAmount("Amount to withdraw: ");
                    if (withdrawal <= account.getBalance()) {
                        account.withdraw(withdrawal);
                        System.out.printf("Withdrew $%.2f%n", withdrawal);
                    } else {
                        System.out.println("There is not enough money in this account.");
                    }
                    break;
                case 3:
                    double deposit = readAmount("Amount to deposit: ");
                    account.deposit(deposit);
                    System.out.printf("Deposited $%.2f%n", deposit);
                    break;
                case 4:
                    finished = true;
                    break;
                default:
                    System.out.println("Please choose a number from 1 to 4.");
            }
        }
    }

    /** loop until the user enters a whole number */
    private int readInt(String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.nextLine();
            System.out.print("Please enter a whole number: ");
        }
        int number = input.nextInt();
        input.nextLine();
        return number;
    }

    /** Keeps asking until the user enters an amount > zero */
    private double readAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (input.hasNextDouble()) {
                double amount = input.nextDouble();
                input.nextLine();
                if (amount > 0) {
                    return amount;
                }
            } else {
                input.nextLine();
            }
            System.out.println("Please enter a positive money amount");
        }
    }
}
