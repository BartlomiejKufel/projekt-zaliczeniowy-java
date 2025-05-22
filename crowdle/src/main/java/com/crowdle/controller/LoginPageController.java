package com.crowdle.controller;

import com.crowdle.model.Users;
import com.crowdle.ApplicationInfo;
import com.crowdle.utility.HibernateUtility;
import com.crowdle.utility.PageMenagerUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.hibernate.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;


public class LoginPageController {

    @FXML public PasswordField passwordField;
    @FXML public TextField usernameField;
    @FXML public ImageView logoImage;
    @FXML public CheckBox keepLoggedCheckBox;
    @FXML public GridPane root;
    @FXML public Button LoginButton;
    @FXML public Button RegisterButton;


    @FXML
    public void initialize() throws FileNotFoundException {

        String theme = "white";
        if(theme.equals("white")){
            Image baner = new Image(new FileInputStream("images/baner_white.png"));
            logoImage.setImage(baner);
        }else{
            Image baner = new Image(new FileInputStream("images/baner_black.png"));
            logoImage.setImage(baner);
        }

    }

    @FXML
    protected void loginSubmitButtonClick(){
        String usernameToCheck = usernameField.getText();
        String passwordToCheck = passwordField.getText();


        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            String query = "FROM Users WHERE username = :username AND password = :password";
            List<Users> users = session.createQuery(query, Users.class)
                    .setParameter("username", usernameToCheck)
                    .setParameter("password", passwordToCheck)
                    .getResultList();

            if(!users.isEmpty()) {
                ApplicationInfo.LoggedUserId = users.getFirst().getUserId();
                Stage stage = (Stage) LoginButton.getScene().getWindow();
                PageMenagerUtility.goToStartPage(stage);
            }else{
                System.out.println("Błąd logowania");
            }
        }


    }

    @FXML
    public void signUpSubmitButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) RegisterButton.getScene().getWindow();
        PageMenagerUtility.goToSignUpPage(stage);

    }
}