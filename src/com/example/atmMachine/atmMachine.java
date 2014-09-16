package com.example.atmMachine;

/**
 * Created by admin on 9/11/14.
 */
import java.util.Scanner;

public class atmMachine {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        int userChoice = 0;
        boolean menuLoop = true;
        boolean okAnswer = false;
        double accountBalance = 500;
        double accountWithdrawal = 0;
        double accountDeposit = 0;

        System.out.println("Welcome to Super Bank Of Bankiness\n" +
                "Where your money is what we want, not in a bad way.\n" +
                "\n");

        while (menuLoop == true) {
            while (!okAnswer) {
                System.out.println("How can we help you today?\n" +
                        "\n" +
                        "1: Check account balance\n" +
                        "2: Withdrawn that sweet, sweet money\n" +
                        "3: Deposit them $$$$$\n" +
                        "4: Exit the system\n");

                if (myScan.hasNextInt()) {
                    okAnswer = true;
                    userChoice = myScan.nextInt();
                } else
                    myScan.nextLine();
            }

            switch (userChoice) {
                case 1:
                    System.out.println("\nWe have $" + accountBalance + " of your money.\n" +
                            "We're keeping great care of it, we promise.\n");
                    okAnswer = false;
                    break;
                case 2:
                    while (okAnswer == true) {
                        System.out.println("\nYou can withdraw money but you had better give it back!\n" +
                                "How much cash do you want?\n");

                        if (myScan.hasNextDouble()) {
                            okAnswer = false;
                            accountWithdrawal = myScan.nextDouble();
                        } else
                            myScan.nextLine();
                    }
                    accountBalance = accountBalance - accountWithdrawal;
                    break;
                case 3:
                    while (okAnswer == true) {
                        System.out.println("You want to give us your money?  Thanks!\n" +
                                "How many dollars are you giving us?\n");

                        if (myScan.hasNextDouble()) {
                            okAnswer = false;
                            accountDeposit = myScan.nextDouble();
                        } else
                            myScan.nextLine();
                    }
                    accountBalance = accountBalance + accountDeposit;
                    break;
                case 4:
                    System.out.println("Come back soon...or we'll keep your money.");
                    menuLoop = false;
                    break;
            }
        }
    }
}
