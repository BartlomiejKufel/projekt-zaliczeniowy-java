package com.crowdle.utility;

import com.crowdle.ApplicationInfo;
import com.crowdle.controller.AdminEditPageController;
import com.crowdle.model.Users;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;


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

    public static void goToSettingsPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/SettingsPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void goToRankingPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/RankingPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void goToAdminPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/AdminPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void goToAdminEditPage(Users selectedUser) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/AdminEditPage.fxml"));
            Parent root = loader.load();

            AdminEditPageController controller = loader.getController();
            controller.setSelectedUser(selectedUser);

            Scene scene = new Scene(root, 700, 520);
            Image icon = new Image(new FileInputStream("images/logo_white.png"));
            Stage stage = new Stage();
            stage.getIcons().add(icon);
            stage.setTitle(ApplicationInfo.Title+ ": Edycja użytkownika");

            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
