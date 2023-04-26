package com.astu.bustransportsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFxml("login"));
        scene.getStylesheets().add(getClass().getResource("Stylesheets/primer-dark.css").toExternalForm());
        stage.setTitle("Bus Ticketing System");
        stage.setScene(scene);
        stage.show();
    }

    public static void switchScene(String fxml) throws IOException {
        scene.setRoot(loadFxml(fxml));
    }
    public static Parent loadFxml(String fxml) throws IOException {
        return FXMLLoader.load(HelloApplication.class.getResource(fxml + ".fxml"));
    }


    public static void main(String[] args) {
        launch();
    }
}