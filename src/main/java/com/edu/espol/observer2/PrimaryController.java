package com.edu.espol.observer2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PrimaryController {
    public static String color;
    @FXML
    private Pane pane;    
    @FXML
    private Button redButton;
    @FXML
    private Button yellowButton;
    @FXML
    private Button pinkButton;

    public void setColor(String color){
        this.color = color;
    }
@FXML

    private void changeColors(MouseEvent event){
        Button source = (Button) event.getSource();
        String nameColor = source.getId().replace("Button", "");
        setColor(nameColor);
        
        Color color;
        int newState=0;
        switch(source.getId()){
            case "redButton":
                color = Color.RED;
                newState=1;
                break;
            case "yellowButton":
                color = Color.YELLOW;
                newState=2;
                break;
            case "pinkButton":
                color = Color.PINK;
                newState=3;
                break;
            default:
                color = Color.WHITE;
                break;
        }
        
        MainSubject.state = newState;
        MainSubject.setState(newState);
        MainSubject.notifyObservers();
        pane.setBackground(new Background(new BackgroundFill(color,null,null)));
        System.out.println("");
        System.out.println("Observer1 state: " + MainSubject.observers.get(0).getState());
        System.out.println("Observer2 state: " + MainSubject.observers.get(1).getState());
        System.out.println("Observer3 state: " + MainSubject.observers.get(2).getState());

    }
}
