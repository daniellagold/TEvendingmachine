package com.techelevator.application;

import com.techelevator.models.VendingMachineItems;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

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
        System.out.println(vendingMachineItemList.size());
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
        while (true ){
            UserOutput.displayPurchaseScreen();
            String choice = UserInput.getPurchaseScreenOption();

            if(choice.equals("money")) {
                // display the items
                userInput.feedingMoney();

            }
            else if(choice.equals("select")) {
                UserOutput.displayItems(vendingMachineItemList);
                UserInput.selectItem();
            }
            else if(choice.equals("finish")) {
                // good bye
                break;
            }
        }
    }
}
