package com.Apples2Apples.observer;

// Subject interface that defines methods to register, remove, and notify observers
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);

    void notifyObservers();
}