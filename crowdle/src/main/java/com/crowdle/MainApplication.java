package com.crowdle;
import com.crowdle.utility.HibernateUtility;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.io.FileInputStream;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            System.out.println("Połączenie z bazą danych");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("LoginPage.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), ApplicationInfo.WindowWidth, ApplicationInfo.WindowHeight);
        Image icon = new Image(new FileInputStream("images/logo_white.png"));
        stage.getIcons().add(icon);
        stage.setTitle(ApplicationInfo.Title);


        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        HibernateUtility.shutdown();
    }

    public static void main(String[] args) {
        launch();
    }
}