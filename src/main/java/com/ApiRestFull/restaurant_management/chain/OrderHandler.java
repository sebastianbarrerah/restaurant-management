package com.ApiRestFull.restaurant_management.chain;

import com.ApiRestFull.restaurant_management.model.OrderReques;

public class OrderHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(OrderReques order) {

    }

//    @Override
//    public void handleRequest(OrderReques order) {
//
//    }
//
//    @Override
//    public void handleRequest(OrderReques order) {
//        if (order.getTotalPrice() > 100) {
//            System.out.println("Se aplica descuento en el pedido.");
//        }
//        if (nextHandler != null) {
//            nextHandler.handleRequest(order);
//        }
//    }
}
