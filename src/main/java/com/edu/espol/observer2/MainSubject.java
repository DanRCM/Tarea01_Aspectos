package com.edu.espol.observer2;

import java.util.ArrayList;
import java.util.List;

public class MainSubject {
    private List<Observer> observers;
    private int state;

    public MainSubject(){
        this.observers = new ArrayList<>();
        this.state = 0;
    }
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.state);
        }
    }
}
