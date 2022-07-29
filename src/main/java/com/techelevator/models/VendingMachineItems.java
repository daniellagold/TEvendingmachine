package com.techelevator.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineItems {
    private String slot;
    private String itemName;
    private BigDecimal price;
    private String type;
    private int quantity;


    public VendingMachineItems(String slot, String itemName, String price, String type) {
        this.slot = slot;
        this.itemName = itemName;
        this.price = new BigDecimal(price);
        this.type = type;
        this.quantity = 6;

    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}

