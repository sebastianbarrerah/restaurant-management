package com.ApiRestFull.restaurant_management.observer;

import java.util.Observer;

public interface Observable {
    void notifyObservers();
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
}
