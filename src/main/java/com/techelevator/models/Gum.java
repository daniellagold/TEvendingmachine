package com.techelevator.models;

public class Gum extends VendingMachineItems{
    public Gum(String slot, String itemName, String price, String type) {
        super(slot, itemName, price, type);
    }

    public String getSound(){
        return "Chewy, Chewy, Lots O Bubbles!";
    }
}
