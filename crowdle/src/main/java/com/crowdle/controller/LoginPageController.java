package com.crowdle.controller;

import com.crowdle.dao.UsersDAO;
import com.crowdle.model.Users;
import com.crowdle.ApplicationInfo;
import com.crowdle.utility.PageMenagerUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class LoginPageController {

    @FXML public PasswordField passwordField;
    @FXML public TextField usernameField;
    @FXML public ImageView logoImage;
    @FXML public GridPane root;
    @FXML public Button loginButton;
    @FXML public Button registerButton;
    @FXML public Label errorLabel;
    @FXML public Label usernameErrorLabel;
    @FXML public Label passwordErrorLabel;


    @FXML
    public void initialize() throws FileNotFoundException {
        Image baner = new Image(new FileInputStream("images/baner_black.png"));
        logoImage.setImage(baner);

        errorLabel.setVisible(false);
    }

    @FXML
    protected void loginButtonClick(){
        errorLabel.setVisible(false);
        usernameErrorLabel.setVisible(false);
        passwordErrorLabel.setVisible(false);
        String usernameToCheck = usernameField.getText();
        String passwordToCheck = passwordField.getText();
        boolean error = false;

        if(usernameToCheck.isEmpty()){usernameErrorLabel.setText("Puste pole!");usernameErrorLabel.setVisible(true);error=true;}
        if(passwordToCheck.isEmpty()){passwordErrorLabel.setText("Puste pole!");passwordErrorLabel.setVisible(true);error=true;}
        if(error){return;}



        Users user = UsersDAO.getUser(usernameToCheck,passwordToCheck);
        if(user!=null) {
            ApplicationInfo.LoggedUserId = user.getUserId();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            PageMenagerUtility.goToStartPage(stage);

        }else{errorLabel.setText("Złe dane logowania!");errorLabel.setVisible(true);}
    }

    @FXML
    public void signUpButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) registerButton.getScene().getWindow();
        PageMenagerUtility.goToSignUpPage(stage);

    }
}