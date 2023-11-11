package Machine;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Accounts {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 1000; // Initial balance for demonstration purposes
    private double savingBalance = 1500;   // Initial balance for demonstration purposes
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,###0.00");

    
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }
    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    // Add similar methods for deposit to Checking, deposit to Savings, and other required functionality

    // Example of a deposit method for Checking
    public double depositToChecking(double amount) {
        checkingBalance += amount;
        return checkingBalance;
    }

    // Example of a deposit method for Savings
    public double depositToSaving(double amount) {
        savingBalance += amount;
        return savingBalance;
    }

    // Example of a withdrawal method for Savings
    public double withdrawFromSaving(double amount) {
        savingBalance -= amount;
        return savingBalance;
    }
}
