package com.edu.espol.observer2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hailiejimenez
 */
public  class CurrentObserver implements Observer {
    private String color;

    public CurrentObserver(String color,int state){
        this.color = color;
        MainSubject.state= state;
    }
    public String getColor(){
        return this.color;
    }
}

