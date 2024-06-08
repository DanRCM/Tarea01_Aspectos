package com.edu.espol.observer2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hailiejimenez
 */
public class CurrentObserver implements Observer {
    @Override
    public void update(int state) {
        String color="";
        switch(state){
            case 1:
                color = "ColorA";
            case 2:
                color = "ColorB";
            case 3:
                color = "ColorC";
        }
                    
        System.out.println("Current background color: " + color);
    }
}

