package com.example.atmMachine;

/**
 * Created by admin on 9/11/14.
 */
import java.util.Scanner;

public class atmMachine {
    public static Scanner myScan = new Scanner(System.in);
    public static boolean okAnswer = true;
    public static int userChoice = 0;
    public static double Balance = 500;

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        boolean menuLoop = true;

        System.out.println("Welcome to Super Bank Of Bankiness\n" +
                "Where your money is what we want, not in a bad way.\n" +
                "\n");

        while (menuLoop == true) {
            userChoice = mainMenuChoiceLoop();
            if (userChoice == 1)
                balanceCheck(Balance);
            if (userChoice == 2)
                withdrawFunds(Balance);
            if (userChoice == 3)
                depositFunds(Balance);
            if (userChoice == 4) {
                System.out.println("Come back soon...or we'll keep your money.");
                menuLoop = false;
            }
        }
    }
    public static int mainMenuChoiceLoop() {
        System.out.println("How can we help you today?\n" +
                    "\n" +
                    "1: Check account balance\n" +
                    "2: Withdrawn that sweet, sweet money\n" +
                    "3: Deposit them $$$$$\n" +
                    "4: Exit the system\n");

            userChoice = menuInput();
            rangeCheck(userChoice, 1, 4);
        return userChoice;
    }
    public static int menuInput() {
        int Choice = 0;
        if (myScan.hasNextInt()) {
            Choice = myScan.nextInt();
        } else {
            System.out.println("Please enter a 1-4.");
            myScan.nextLine();
            menuInput();
        } return Choice;
    }
    public static void rangeCheck(int userChoice, int x, int y) {
        boolean choiceLoop = true;
        while (choiceLoop) {
            if ((userChoice >= x) && (userChoice <= y))
                choiceLoop = false;
            else {
                System.out.println("Please enter a 1-4.");
                menuInput();
            }
        }
    }
    public static void balanceCheck(double accountBalance) {
        System.out.println("\nWe have $" + accountBalance + " of your money.\n" +
                "We're keeping great care of it, we promise.\n");
    }
    public static void withdrawFunds(double accountBalance) {
        double accountWithdrawal = 0;
        while (okAnswer == true) {
            System.out.println("\nYou can withdraw money but you had better give it back!\n" +
                    "How much cash do you want?\n");

            if (myScan.hasNextDouble()) {
                okAnswer = false;
                accountWithdrawal = myScan.nextDouble();

            } else
                myScan.nextLine();
        }
        Double newBalance = accountBalance - accountWithdrawal;
        Balance = newBalance;
        System.out.println("Your new balance is: " + newBalance);
        myScan.nextLine();
        okAnswer = true;
    }
    public static void depositFunds (double accountBalance) {
        double accountDeposit = 0;
        while (okAnswer == true) {
            System.out.println("You want to give us your money?  Thanks!\n" +
                    "How many dollars are you giving us?\n");

            if (myScan.hasNextDouble()) {
                okAnswer = false;
                accountDeposit = myScan.nextDouble();
            } else
                myScan.nextLine();
        }
        Double newBalance = accountBalance + accountDeposit;
        Balance = newBalance;
        System.out.println("Your new balance is: " + newBalance);
        myScan.nextLine();
    }
}
