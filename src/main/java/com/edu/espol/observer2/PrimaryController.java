package com.edu.espol.observer2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PrimaryController {

    @FXML
    private Pane pane;    
    @FXML
    private Button redButton;
    @FXML
    private Button yellowButton;
    @FXML
    private Button pinkButton;
@FXML
    private void changeColors(MouseEvent event){
        Button source = (Button) event.getSource();
        Color color;
        switch(source.getId()){
            case "redButton":
                color = Color.RED;
                break;
            case "yellowButton":
                color = Color.YELLOW;
                break;
            case "pinkButton":
                color = Color.PINK;
                break;
            default:
                color = Color.WHITE;
                break;
        }
        pane.setBackground(new Background(new BackgroundFill(color,null,null)));
        System.out.println("Background color changed to: " + color.toString());
    }
}
