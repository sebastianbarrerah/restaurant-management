package com.ApiRestFull.restaurant_management.Observer;

import java.util.ArrayList;
import java.util.List;

public class CustomerSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private boolean isFrequentCustomer;

    public void setFrequentCustomer(boolean isFrequentCustomer) {
        this.isFrequentCustomer = isFrequentCustomer;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("El cliente ahora es frecunte");
        }
    }
}
