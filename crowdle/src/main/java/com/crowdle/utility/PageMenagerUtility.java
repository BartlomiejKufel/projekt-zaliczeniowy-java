package com.crowdle.utility;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class PageMenagerUtility {

    public static void GoToStartPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/StartPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void GoToLoginPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/LoginPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
