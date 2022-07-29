package com.techelevator.application;

import com.techelevator.models.VendingMachineItems;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.techelevator.ui.UserOutput.displayHomeScreen;

public class VendingMachine {

    private List<VendingMachineItems> vendingMachineItemList;
    private UserInput userInput= new UserInput();

    public void run() {
        FileReader fileReader = new FileReader();
        this.vendingMachineItemList = fileReader.readFile();
        System.out.println(vendingMachineItemList.get(0).getSlot());
        while(true) {
            displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            System.out.println(choice);
            if(choice.equals("display")) {
                UserOutput.displayItems(vendingMachineItemList);
            } else if(choice.equals("purchase")) {
                purchaseMenu();
                // make a purchase
            } else if(choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }

    public void purchaseMenu() {
        BigDecimal currentMoneyProvided = new BigDecimal("0.00");
        while (true ){
            UserOutput.displayPurchaseScreen();
            String choice = UserInput.getPurchaseScreenOption(currentMoneyProvided);

            if(choice.equals("money")) {
                // display the items
                currentMoneyProvided = userInput.feedingMoney(currentMoneyProvided);

            }
            else if(choice.equals("select")) {
                UserOutput.displayItems(vendingMachineItemList);
                String slotNumber =  UserInput.selectItem();
                currentMoneyProvided = vendingItem(slotNumber, currentMoneyProvided);
            }
            else if(choice.equals("finish")) {
                // good bye
                break;
            }
        }
    }

    public BigDecimal vendingItem(String slotNumber, BigDecimal moneyAmount) {
        boolean isFound = false;
        for (int i = 0; i < vendingMachineItemList.size(); i++) {
            if (slotNumber.equals(vendingMachineItemList.get(i).getSlot())) {
                isFound = true;
                if (moneyAmount.compareTo(vendingMachineItemList.get(i).getPrice()) == 0 || moneyAmount.compareTo(vendingMachineItemList.get(i).getPrice()) == 1) {
                    System.out.println(vendingMachineItemList.get(i).getItemName() + " " + vendingMachineItemList.get(i).getPrice());
                    System.out.println(vendingMachineItemList.get(i).getSound());
                    moneyAmount = moneyAmount.subtract(vendingMachineItemList.get(i).getPrice());


                } else {
                    System.out.println("You do not have enough money");
                }
            }
        }
        if(isFound == false) {
            System.out.println("That was an invalid slot\n");
        }
        return moneyAmount;
    }
}
