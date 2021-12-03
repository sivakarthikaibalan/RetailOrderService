package com.epam.retail.model;

import java.util.List;

public class OrderSummary {
    String orderId;
    List<ItemEntry> itemEntryList;
    double grandTotal;

    public List<ItemEntry> getItemEntryList() {
        return itemEntryList;
    }

    public void setItemEntryList(List<ItemEntry> itemEntryList) {
        this.itemEntryList = itemEntryList;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderSummary(List<ItemEntry> itemEntryList, double grandTotal, String orderId) {
        this.itemEntryList = itemEntryList;
        this.grandTotal = grandTotal;
        this.orderId = orderId;
    }
}
