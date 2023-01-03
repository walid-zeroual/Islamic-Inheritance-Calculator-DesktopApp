package com.example.Inheritance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;



public class InheritanceApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.initStyle(StageStyle.DECORATED);
        FXMLLoader fxmlLoader = new FXMLLoader(InheritanceApplication.class.getResource("inheritance.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Inheritance Calculator!");

        stage.getIcons().add(new Image("C:\\Users\\ACER\\IdeaProjects\\InheritanceCalculator\\src\\main\\resources\\images\\inheritance-law-1.png"));
        stage.setOpacity(1f);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}