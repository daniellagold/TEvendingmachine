package com.techelevator.ui;

import com.techelevator.application.FileReader;
import com.techelevator.models.VendingMachineItems;

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
    private static BigDecimal moneyAmount = new BigDecimal("0");
    private static List<VendingMachineItems> vendingMachineList;




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
    public BigDecimal feedingMoney() {
        System.out.println("Please enter only whole dollar amounts.");
        System.out.println("Please enter the amount of money you want to use: ");

        String moneyString = scanner.nextLine();
        int money = Integer.parseInt(moneyString);
        BigDecimal bigDecimal= BigDecimal.valueOf(money);

        moneyAmount = moneyAmount.add(bigDecimal);

        return moneyAmount;
    }


    public static String getPurchaseScreenOption() {

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



    public static void selectItem(){
        System.out.println("Please enter the slot number of the item you want to purchase: ");
        String slotNumber = scanner.nextLine();
        FileReader fileReader = new FileReader();
        vendingMachineList = fileReader.readFile();

        for (int i = 0; i < vendingMachineList.size(); i++) {
            if (slotNumber.equals(vendingMachineList.get(i).getSlot())){
                System.out.println(vendingMachineList.get(i).getItemName() + " " + vendingMachineList.get(i).getPrice());
                moneyAmount = moneyAmount.subtract(vendingMachineList.get(i).getPrice());
                  }

        }

    }
}

