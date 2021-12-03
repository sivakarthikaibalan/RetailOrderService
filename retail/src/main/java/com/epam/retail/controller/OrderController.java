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

    // Endpoint for creating new order
    @PostMapping("/newOrder")
    private OrderSummary receiveOrders(@RequestParam(value = "apple", defaultValue = "0") int apple, @RequestParam(value = "orange", defaultValue = "0") int orange) {
        List<ItemEntry> itemEntryList = new ArrayList<>();
        double grandTotal = 0;
        // if the apple quantity is 0, or it is not given in the order ignore adding it to the summary
        if (!(apple <= 0)) {
            int disCounterQuantity = apple>1?apple/2 + apple%2:apple;
            itemEntryList.add(new ItemEntry("Apples", appleRate, appleRate * disCounterQuantity, apple));
            //amending grand total with each item total
            grandTotal += appleRate * disCounterQuantity;
        }
        // if the orange quantity is 0, or it is not given in the order ignore adding it to the summary
        if (!(orange <= 0)) {
            int disCounterQuantity = orange/3 * 2 + orange%3;
            itemEntryList.add(new ItemEntry("Oranges", orangeRate, orangeRate * disCounterQuantity, orange));
            //amending grand total with each item total
            grandTotal += orangeRate * disCounterQuantity;
        }
        String orderId = UUID.randomUUID().toString();
        // Creating final object to be returned
        OrderSummary orderSummary = new OrderSummary(itemEntryList, grandTotal, orderId);
        ordersList.put(orderId, orderSummary);
        return orderSummary;

    }
    //Endpoint to get a particular order using the order ID
    @GetMapping("/getOrder")
    private OrderSummary getOrder(@RequestParam(value = "orderId") String orderId){
        return ordersList.get(orderId);
    }
    //Endpoint to get all orders
    @GetMapping("/getAllOrders")
    private Object getAllOrders(){
        return ordersList.values();
    }
}
