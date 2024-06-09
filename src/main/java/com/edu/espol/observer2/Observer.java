package com.edu.espol.observer2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author hailiejimenez
 */
public interface Observer {
    public static void update(int state,String colorButton) {
        String color=colorButton.replace("Button", "");
    }
    public int getState();
    public String getColor();
}
