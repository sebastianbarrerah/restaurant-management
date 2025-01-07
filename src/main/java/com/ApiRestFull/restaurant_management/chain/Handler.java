package com.ApiRestFull.restaurant_management.chain;

import com.ApiRestFull.restaurant_management.model.OrderReques;

public interface Handler {
    void setNext(Handler handler);
    void handleRequest(OrderReques order);
}
