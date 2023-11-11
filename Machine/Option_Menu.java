package Machine;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.WeakHashMap;

public class Option_Menu extends Accounts {
    private final Scanner menuInput = new Scanner(System.in);
    private final DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    private final Map<Integer, Integer> data = new WeakHashMap<Integer, Integer>();


    public Option_Menu() {
        // Initialize customer data
        data.put(22008, 9818);
        data.put(22010, 9820);
    }

    public void login() throws IOException {
        int x = 1;

        do {
            try {
                System.out.println("Welcome to the ATM Project!");

                System.out.println("Enter your Customer No: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your PIN No: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only Numbers." + "\n");
                x = 2;
            }

            boolean loginSuccessful = checkLoginCredentials();

            if (loginSuccessful) {
                getAccountType();
            } else {
                System.out.println("\n" + "Wrong Customer Number or Pin Number." + "\n");
            }
        } while (x == 1);
    }

    private boolean checkLoginCredentials() {
        for (Entry<Integer, Integer> entry : data.entrySet()) {
            if (entry.getKey().equals(getCustomerNumber()) && entry.getValue().equals(getPinNumber())) {
                return true;
            }
        }
        return false;
    }

    public void getAccountType() {
        System.out.println("Select the Account you want to access:  ");
        System.out.println("Type 1 - Checking Account ");
        System.out.println("Type 2 - Savings Account ");
        System.out.println("Type 3 - Exit ");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you for using this ATM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");
        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()) );
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            // Handle other cases for deposit and exit

            default:
                System.out.println("Invalid Choice.");
                getChecking();
        }
    }

    public void getSaving() {
        // Implement the functionality for the Savings Account
        System.out.println("Savings Account:");
        // Add options for Savings Account
        // Example:
        // System.out.println("Type 1 - View Savings Balance");
        // System.out.println("Type 2 - Withdraw from Savings");
        // System.out.println("Type 3 - Deposit to Savings");
        // System.out.println("Type 4 - Exit");
        // System.out.print("Choice: ");
        // int selection = menuInput.nextInt();
        // Implement the corresponding functionality based on the user's choice
    }

    public void getCheckingWithdrawInput() {
        // Implement the functionality for withdrawing from the Checking Account
        System.out.println("Enter the amount to withdraw from Checking: ");
        double amount = menuInput.nextDouble();
        // Implement the withdrawal logic from the Checking Account
    }

    // Add similar methods for deposit to Checking, deposit to Savings, and other required functionality

    public static void main(String[] args) {
        Option_Menu optionMenu = new Option_Menu();

        try {
            optionMenu.login();
        } catch (IOException e) {
            System.out.println("An error occurred during login.");
            e.printStackTrace();
        }
    }
}
