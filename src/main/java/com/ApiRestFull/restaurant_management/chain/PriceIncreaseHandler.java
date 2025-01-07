package com.ApiRestFull.restaurant_management.chain;

import com.ApiRestFull.restaurant_management.model.OrderReques;

public class PriceIncreaseHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(OrderReques order) {

    }
//
//    @Override
//    public void handleRequest(Order order) {
//        if (order.isPopularDish()) {
//            System.out.println("Se aplica aumento de precio al plato popular.");
//        }
//        if (nextHandler != null) {
//            nextHandler.handleRequest(order);
//        }
//    }
}
