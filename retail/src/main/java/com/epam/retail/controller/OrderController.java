package com.epam.retail.controller;

import com.epam.retail.model.ItemEntry;
import com.epam.retail.model.OrderSummary;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class OrderController {

    double appleRate = 0.6;
    double orangeRate = 0.25;
    Map<String, OrderSummary> ordersList = new HashMap<>();

    @PostMapping("/newOrder")
    private OrderSummary receiveOrders(@RequestParam(value = "apple", defaultValue = "0.0") double apple, @RequestParam(value = "orange", defaultValue = "0.0") double orange) {
        List<ItemEntry> itemEntryList = new ArrayList<>();
        double grandTotal = 0;
        if (!(apple <= 0)) {
            itemEntryList.add(new ItemEntry("Apples", appleRate, appleRate * apple, apple));
            grandTotal += appleRate * apple;
        }
        if (!(orange <= 0)) {
            itemEntryList.add(new ItemEntry("Oranges", orangeRate, orangeRate * orange, orange));
            grandTotal += orangeRate * orange;
        }
        String orderId = UUID.randomUUID().toString();
        OrderSummary orderSummary = new OrderSummary(itemEntryList, grandTotal, orderId);
        ordersList.put(orderId, orderSummary);
        return orderSummary;

    }
}
