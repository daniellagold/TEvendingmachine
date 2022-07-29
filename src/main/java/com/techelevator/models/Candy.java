package com.techelevator.models;

public class Candy extends VendingMachineItems {

    public Candy(String slot, String itemName, String price, String type) {
        super(slot, itemName, price, type);
    }


    public String getSound(){
        return "Sugar, Sugar, so Sweet!";
    }
}
