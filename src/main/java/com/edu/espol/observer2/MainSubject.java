package com.edu.espol.observer2;

import java.util.ArrayList;
import java.util.List;

public class MainSubject {
    public static List<Observer> observers;
    public static int state;

    public MainSubject(){
        this.observers = new ArrayList<>();
        this.state = 0;
    }
    public Observer getObserver(int index){
        Observer currObs = observers.get(index);
        return currObs;
    }
    public int getState() {
        return state;
    }

    public static void setState(int state) {
        MainSubject.state = state;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public static void notifyObservers() {
        for (int i=0;i<observers.size();i++) {
            Observer.update(state, PrimaryController.color);
//            observer.update(this.state,PrimaryController.color);
        }
        System.out.println("Current background color set to: " +PrimaryController.color);
        System.out.println("The state of the observers has changed!");
    }
}
