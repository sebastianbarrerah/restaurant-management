package com.ApiRestFull.restaurant_management.Observer;

public class CustomerObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Notificación: " + message);
    }
}
