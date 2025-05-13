package com.crowdle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.FileInputStream;

public class MainApplication extends Application {
    int windowHeight = 720;
    int windowWidth = 1280;
    String title = "Crowdle";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), windowWidth, windowHeight);

        Image icon = new Image(new FileInputStream("images/logo_white.png"));
        stage.getIcons().add(icon);

        stage.setTitle(title);


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}