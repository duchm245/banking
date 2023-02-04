import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Class constructor
    public Account(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    //Function for Depositing money
    void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    //Function for Withdrawing money
    void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    //Function showing the previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    //Function calculating interest of current funds after a number of year
    void calculateInterest(int year) {
        double interestRate = 0.0185;
        double newBalance = balance + (balance * interestRate * year);

        DecimalFormat df = new DecimalFormat("#.0000");
        System.out.println(df.format(interestRate));
        System.out.println("The current interest rate is " + (df.format(interestRate)) + "%");
        System.out.println("After " + year + " years, you balance will be: " + newBalance);
    }


    public void showMenu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome, " + Account.this.customerName);
        System.out.println("Your ID is: " + customerID);
        System.out.println("\nWhat would you like to do?");
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println("\nEnter an option: ");
            char option1 = sc.next().charAt(0);
            option = Character.toUpperCase(option1);

            switch (option) {
                case 'A':
                    System.out.println("Balance = $" + balance);
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = sc.nextInt();
                    deposit(amount);
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    break;
                case 'D':
                    getPreviousTransaction();
                    break;
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = sc.nextInt();
                    calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("====================================");
                    break;
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E or F");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}
