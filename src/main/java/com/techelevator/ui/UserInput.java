package com.techelevator.ui;

import com.techelevator.application.FileReader;
import com.techelevator.models.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 *
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);


    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        System.out.println("option = " + option);
        if (option.equals("d")) {
            return "display";
        }
        else if (option.equals("p")) {
            return "purchase";
        }
        else if (option.equals("e")) {
            return "exit";
        }
        else {
            return "";
        }

    }
    public static BigDecimal feedingMoney(BigDecimal moneyAmount) {
        System.out.println("Please enter only whole dollar amounts. ($1, $5, $10, $20)");
        System.out.println("Please enter the amount of money you want to use: ");

        String moneyString = scanner.nextLine();
        if(moneyString.equals("1") || moneyString.equals("5") || moneyString.equals("10") || moneyString.equals("20")) {
            int money = Integer.parseInt(moneyString);
            BigDecimal bigDecimal= BigDecimal.valueOf(money);
            moneyAmount = moneyAmount.add(bigDecimal);
        } else {
            System.out.println("That wasn't a valid amount\n");

        }

        return moneyAmount;
    }

    public static BigDecimal feedingMoneyTwo(BigDecimal moneyAmount) {

        String moneyString = scanner.nextLine();
        if(moneyString.equals("1") || moneyString.equals("5") || moneyString.equals("10") || moneyString.equals("20")) {
            int money = Integer.parseInt(moneyString);
            BigDecimal bigDecimal= BigDecimal.valueOf(money);
            moneyAmount = moneyAmount.add(bigDecimal);
        }

        return moneyAmount;
    }


    public static String getPurchaseScreenOption(BigDecimal moneyAmount) {

        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");

        System.out.println();
        System.out.println("Current Money Provided: " + moneyAmount);

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("m")) {
            return "money";
        }
        else if (option.equals("s")) {
            return "select";
        }
        else if (option.equals("f")) {
            return "finish";
        }
        else {
            return "";
        }
    }


    public static String selectItem() {
        System.out.println("Please enter the slot number of the item you want to purchase: ");
        String slotNumber = scanner.nextLine().toUpperCase();
        return slotNumber;

    }
}

