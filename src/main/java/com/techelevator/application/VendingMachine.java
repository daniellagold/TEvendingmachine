package com.techelevator.application;

import com.techelevator.logger.Logger;
import com.techelevator.models.VendingMachineItems;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.techelevator.ui.UserOutput.displayHomeScreen;

public class VendingMachine {
    Logger logger;

    public void setVendingMachineItemList(List<VendingMachineItems> vendingMachineItemList) {
        this.vendingMachineItemList = vendingMachineItemList;
    }

    private List<VendingMachineItems> vendingMachineItemList;
    private UserInput userInput = new UserInput();


    public VendingMachine() {
        logger = new Logger("Audit.txt");
    }


    public void run() {
        FileReader fileReader = new FileReader();
        this.vendingMachineItemList = fileReader.readFile();

        while (true) {
            displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            System.out.println(choice);
            if (choice.equals("display")) {
                UserOutput.displayItems(vendingMachineItemList);
            } else if (choice.equals("purchase")) {
                purchaseMenu();
                // make a purchase
            } else if (choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }

    public void purchaseMenu() {
        BigDecimal currentMoneyProvided = new BigDecimal("0.00");
        while (true) {
            UserOutput.displayPurchaseScreen();
            String choice = UserInput.getPurchaseScreenOption(currentMoneyProvided);

            if (choice.equals("money")) {
                // display the items
                currentMoneyProvided = userInput.feedingMoney(currentMoneyProvided);
                logger.write(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS) + "\t MONEY FED:\t\t\t\t\t$" + userInput.feedingMoneyTwo(currentMoneyProvided) + "\t$" + currentMoneyProvided);

            } else if (choice.equals("select")) {
                UserOutput.displayItems(vendingMachineItemList);
                String slotNumber = UserInput.selectItem();
                currentMoneyProvided = vendingItem(slotNumber, currentMoneyProvided);

            } else if (choice.equals("finish")) {

                currentMoneyProvided = getChange(currentMoneyProvided);

                break;
            }
        }
    }

    public BigDecimal getChange(BigDecimal moneyAmount) {

        BigDecimal zero = new BigDecimal("0.00");
        String changeAmount = "Your change is ";
        int changeDollars = 0;
        int changeQuarters = 0;
        int changeDimes = 0;
        int changeNickels = 0;
        int changePennies = 0;

        logger.write(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS) + "\t CHANGE GIVEN:\t\t\t\t$" + moneyAmount + "\t$" + zero);

        while (moneyAmount.compareTo(zero) == 1) {
            if (moneyAmount.compareTo(BigDecimal.valueOf(0.99)) == 1) {
                changeDollars++;
                moneyAmount = moneyAmount.subtract(BigDecimal.valueOf(1.00));

            } else if (moneyAmount.compareTo(BigDecimal.valueOf(0.25)) == 1 || moneyAmount.compareTo(BigDecimal.valueOf(0.25)) == 0) {
                changeQuarters++;
                moneyAmount = moneyAmount.subtract(BigDecimal.valueOf(0.25));
            } else if (moneyAmount.compareTo(BigDecimal.valueOf(0.10)) == 1 || moneyAmount.compareTo(BigDecimal.valueOf(0.10)) == 0) {
                changeDimes++;
                moneyAmount = moneyAmount.subtract(BigDecimal.valueOf(0.10));
            } else if (moneyAmount.compareTo(BigDecimal.valueOf(0.05)) == 1 || moneyAmount.compareTo(BigDecimal.valueOf(0.05)) == 0) {
                changeNickels++;
                moneyAmount = moneyAmount.subtract(BigDecimal.valueOf(0.05));
            } else if (moneyAmount.compareTo(BigDecimal.valueOf(0.01)) == 1 || moneyAmount.compareTo(BigDecimal.valueOf(0.01)) == 0) {
                changePennies++;
                moneyAmount = moneyAmount.subtract(BigDecimal.valueOf(0.01));
            }
        }
        System.out.println(changeAmount + changeDollars + " dollars, " + changeQuarters + " quarters, " +
                changeDimes + " dimes, " + changeNickels + " nickels, " + changePennies + " pennies. ");

        return moneyAmount;

    }

    public BigDecimal vendingItem(String slotNumber, BigDecimal moneyAmount) {
        boolean isFound = false;
        for (int i = 0; i < vendingMachineItemList.size(); i++) {
            if (slotNumber.equals(vendingMachineItemList.get(i).getSlot())) {
                isFound = true;
                if (moneyAmount.compareTo(vendingMachineItemList.get(i).getPrice()) == 0 || moneyAmount.compareTo(vendingMachineItemList.get(i).getPrice()) == 1) {
                    if (vendingMachineItemList.get(i).getQuantity() > 0) {
                        System.out.println(vendingMachineItemList.get(i).getItemName() + " " + vendingMachineItemList.get(i).getPrice());
                        System.out.println(vendingMachineItemList.get(i).getSound());

                        vendingMachineItemList.get(i).setQuantity(vendingMachineItemList.get(i).getQuantity() - 1);
                        logger.write(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS) + "\t" + vendingMachineItemList.get(i).getItemName() + "\t\t"
                                + vendingMachineItemList.get(i).getSlot() + "\t\t\t\t$" + moneyAmount + "\t$" + moneyAmount.subtract(vendingMachineItemList.get(i).getPrice()));

                        moneyAmount = moneyAmount.subtract(vendingMachineItemList.get(i).getPrice());

                    } else {
                        System.out.println("The item you selected is out of stock");
                    }
                } else {
                    System.out.println("You do not have enough money");
                }
            }
        }
        if (isFound == false) {
            System.out.println("That was an invalid slot\n");
        }
        return moneyAmount;
    }
}
