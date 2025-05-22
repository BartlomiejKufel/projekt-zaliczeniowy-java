package com.crowdle.utility;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class PageMenagerUtility {

    public static void goToStartPage(Stage primaryStage) {
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

    public static void goToLoginPage(Stage primaryStage) {
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

    public static void goToSignUpPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/SignUpPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
