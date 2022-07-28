package com.techelevator.models;

public class Drink extends VendingMachineItems{
    public Drink(String slot, String itemName, String price, String type) {
        super(slot, itemName, price, type);
    }
    public String getSound(){
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
