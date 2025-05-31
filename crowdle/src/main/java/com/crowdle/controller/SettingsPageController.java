package com.crowdle.controller;

import com.crowdle.ApplicationInfo;
import com.crowdle.dao.UsersDAO;
import com.crowdle.model.Users;
import com.crowdle.utility.PageMenagerUtility;
import com.crowdle.utility.ValidationUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SettingsPageController {


    @FXML public Button saveButton;
    @FXML public ImageView iconImageView;
    @FXML public Button backButton;
    @FXML public TextField usernameField;
    @FXML public Label errorUserLabel;
    @FXML public TextField emailField;
    @FXML public Label errorMailLabel;
    @FXML public PasswordField passwordField;
    @FXML public Label errorPasswordLabel;
    @FXML public PasswordField passwordConfirmField;
    @FXML public Label errorConfirmLabel;
    @FXML public Label saveLabel;


    private Users loggedUser;

    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);

        setUserInformation();
        saveButton.setVisible(false);
        saveLabel.setVisible(false);

        usernameField.textProperty().addListener((obs, oldText, newText) ->showButton());
        emailField.textProperty().addListener((obs, oldText, newText) ->showButton());
        passwordField.textProperty().addListener((obs, oldText, newText) ->showButton());

    }

    @FXML
    public void backButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        PageMenagerUtility.goToStartPage(stage);

    }


    @FXML
    public void saveButtonClick(ActionEvent actionEvent) {
        errorConfirmLabel.setVisible(false);
        errorPasswordLabel.setVisible(false);
        errorMailLabel.setVisible(false);
        errorUserLabel.setVisible(false);


        String newUsername = usernameField.getText();
        String newPassword = passwordField.getText();
        String confirmPassword = passwordConfirmField.getText();
        String newEmail = emailField.getText();
        boolean error=false;

        if(newUsername.isEmpty()){errorUserLabel.setText("Puste pole!"); errorUserLabel.setVisible(true);error=true;}
        if(newEmail.isEmpty()){errorMailLabel.setText("Puste pole!");errorMailLabel.setVisible(true);error=true;}
        else if (!ValidationUtility.isValidEmail(newEmail)) {errorMailLabel.setText("Niepoprawny adres e-mail! Upewnij się, że zawiera znak '@' oraz poprawną nazwę domeny (np. example.com)"); errorMailLabel.setVisible(true); error=true;}
        if(newPassword.isEmpty()){errorPasswordLabel.setText("Puste pole!");errorPasswordLabel.setVisible(true); error=true;}
        else if (!ValidationUtility.isValidPassword(newPassword)){errorPasswordLabel.setText("Hasło powinno zawierać co najmniej 8 znaków, w tym przynajmniej jedną wielką literę, jedną małą literę, jedną cyfrę oraz jeden znak specjalny!");errorPasswordLabel.setVisible(true); error=true;}
        if(confirmPassword.isEmpty()){errorConfirmLabel.setText("Puste pole!");errorConfirmLabel.setVisible(true); error=true;}
        else if(!newPassword.equals(confirmPassword)){errorConfirmLabel.setText("Błędne hasło!"); errorConfirmLabel.setVisible(true); error=true;}
        if(error) return;

        UsersDAO.updateUser(loggedUser.getUserId(), newUsername, newEmail,newPassword);
        setUserInformation();
        showButton();
        saveLabel.setVisible(true);
    }


    private void setUserInformation(){
        loggedUser = UsersDAO.getUser(ApplicationInfo.LoggedUserId);
        usernameField.setText(loggedUser.getUsername());
        emailField.setText(loggedUser.getEmail());
        passwordField.setText(loggedUser.getPassword());
        passwordConfirmField.setText(loggedUser.getPassword());
    }


    private void showButton() {
        saveLabel.setVisible(false);
        if(!usernameField.getText().equals(loggedUser.getUsername())){saveButton.setVisible(true); return;}
        if(!emailField.getText().equals(loggedUser.getEmail())){saveButton.setVisible(true); return;}
        if(!passwordField.getText().equals(loggedUser.getPassword())){saveButton.setVisible(true); return;}

        saveButton.setVisible(false);
    }
}
