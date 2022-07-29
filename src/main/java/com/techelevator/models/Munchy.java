package com.techelevator.models;

public class Munchy extends VendingMachineItems {

    public Munchy(String slot, String itemName, String price, String type) {
        super(slot, itemName, price, type);
    }

    public String getSound(){
        return "Munchy, Munchy, so Good!";
    }

}
