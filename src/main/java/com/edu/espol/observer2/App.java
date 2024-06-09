package com.edu.espol.observer2;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        MainSubject subjects = new MainSubject();
        CurrentObserver obs;
        ArrayList<String> colors = new ArrayList<>();
        
        colors.add("redButton");
        colors.add("yellowButton");
        colors.add("pinkButton");

        
        for(int i=0;i<colors.size();i++){
            String color = colors.get(i).replace("Button","");
            CurrentObserver observer = new CurrentObserver(color, i+1);
            subjects.addObserver(observer);
        }
        launch();
    }

}