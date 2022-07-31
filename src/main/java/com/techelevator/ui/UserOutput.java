package com.techelevator.ui;

import com.techelevator.models.VendingMachineItems;

import java.util.List;

public class UserOutput {

    public static void displayItems(List<VendingMachineItems> vendingList) {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("             Vending Machine Inventory");
        System.out.println("***************************************************");
        System.out.println();
        for (int i = 0; i < vendingList.size(); i++) {
            System.out.printf("%-8s %-20s %-8s %-8s\n" ,vendingList.get(i).getSlot(), vendingList.get(i).getItemName(),
                    vendingList.get(i).getPrice(), vendingList.get(i).getQuantity());
        }
    }

    public static void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayPurchaseScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Purchase");
        System.out.println("***************************************************");
        System.out.println();
    }

}
