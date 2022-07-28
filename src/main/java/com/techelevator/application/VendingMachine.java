package com.techelevator.application;

import com.techelevator.models.VendingMachineItems;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private List<VendingMachineItems> vendingMachineItemList;

    public void run() {
        FileReader fileReader = new FileReader();
        this.vendingMachineItemList = fileReader.readFile();
        System.out.println(vendingMachineItemList.get(1).getPrice());
        while(true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            System.out.println(choice);
            if(choice.equals("display")) {
                // display the items
            }
            else if(choice.equals("purchase")) {
                // make a purchase
            }
            else if(choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }
}
