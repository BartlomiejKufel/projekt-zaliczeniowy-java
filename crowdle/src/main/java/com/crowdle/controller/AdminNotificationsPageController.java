package com.crowdle.controller;

import com.crowdle.ApplicationInfo;
import com.crowdle.dao.NotificationsDAO;
import com.crowdle.model.Notifications;
import com.crowdle.utility.PageMenagerUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AdminNotificationsPageController {
    @FXML public GridPane root;
    @FXML public Button notificationButton;
    @FXML public ImageView iconImageView;
    @FXML public Button backButton;
    @FXML public Button questionsButton;
    @FXML public Button userButton;
    @FXML public TextArea messageTextArea;
    @FXML public TextField titleTextField;
    @FXML public Label confirmationLabel;
    @FXML public Label titleErrorLabel;
    @FXML public Label messageErrorLabel;

    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);

        resetLabelVisibility();
    }

    @FXML
    public void backButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        PageMenagerUtility.goToStartPage(stage);
    }

    @FXML
    public void usersButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) userButton.getScene().getWindow();
        PageMenagerUtility.goToAdminPage(stage);
    }

    @FXML
    public void questionsButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) questionsButton.getScene().getWindow();
        PageMenagerUtility.goToAdminQuestionsPage(stage);
    }

    @FXML
    public void sendNotificationButtonClick(ActionEvent actionEvent) {
        resetLabelVisibility();
        String title = titleTextField.getText().stripTrailing().stripLeading();
        String message = messageTextArea.getText().stripTrailing().stripLeading();

        boolean error=false;
        if(title.isEmpty()){error=true; titleErrorLabel.setVisible(true); titleErrorLabel.setText("Puste pole!");}
        if(message.isEmpty()){error=true; messageErrorLabel.setVisible(true); messageErrorLabel.setText("Puste pole!");}
        else if(message.length() > 255){error=true; messageErrorLabel.setVisible(true); messageErrorLabel.setText("Treść nie może mieć więcej niż 255 znaków!");}
        if(error){return;}

        NotificationsDAO.addNotification(ApplicationInfo.LoggedUserId, title, message);
        titleTextField.setText("");
        messageTextArea.setText("");
        confirmationLabel.setVisible(true);
    }

    @FXML
    public void notificationButtonClick(ActionEvent actionEvent) {
        PageMenagerUtility.goToNotificationWindow();
    }

    private void resetLabelVisibility(){
        confirmationLabel.setVisible(false);
        titleErrorLabel.setVisible(false);
        messageErrorLabel.setVisible(false);
    }
}
