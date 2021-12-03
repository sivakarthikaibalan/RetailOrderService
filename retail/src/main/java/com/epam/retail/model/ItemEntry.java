package com.epam.retail.model;

public class ItemEntry {

    private String itemName;
    double itemRate;
    double itemQuantity;
    double itemTotal;


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemRate() {
        return itemRate;
    }

    public void setItemRate(double itemRate) {
        this.itemRate = itemRate;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

    public double getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public ItemEntry(String itemName, double itemRate, double itemTotal, double itemQuantity) {
        this.itemName = itemName;
        this.itemRate = itemRate;
        this.itemTotal = itemTotal;
        this.itemQuantity = itemQuantity;
    }

    public ItemEntry() {
    }
}
