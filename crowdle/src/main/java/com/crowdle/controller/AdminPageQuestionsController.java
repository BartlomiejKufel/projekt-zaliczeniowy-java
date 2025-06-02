package com.crowdle.controller;

import com.crowdle.utility.PageMenagerUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AdminPageQuestionsController {
    @FXML public GridPane root;
    @FXML public ImageView iconImageView;
    @FXML public Button notificationButton;
    @FXML public Button userButton;
    @FXML public Button backButton;
    @FXML public Button goToNotificationButton;

    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);
    }

    @FXML
    public void backButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        PageMenagerUtility.goToStartPage(stage);
    }

    @FXML
    public void notificationAdminButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) goToNotificationButton.getScene().getWindow();
        PageMenagerUtility.goToAdminNotificationPage(stage);
    }


    @FXML
    public void usersButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) userButton.getScene().getWindow();
        PageMenagerUtility.goToAdminPage(stage);
    }

    @FXML
    public void notificationButtonClick(ActionEvent actionEvent) {
        PageMenagerUtility.goToNotificationWindow();
    }
}
