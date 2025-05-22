package com.crowdle.controller;

import com.crowdle.model.Users;
import com.crowdle.utility.HibernateUtility;
import com.crowdle.utility.PageMenagerUtility;
import com.crowdle.utility.ValidationUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class SignUpPageController {
    @FXML public Button RegisterButton;
    @FXML public Button GoBackButton;
    @FXML public TextField usernameField;
    @FXML public PasswordField passwordField;
    @FXML public PasswordField passwordConfirmField;
    @FXML public ImageView logoImage;
    @FXML public TextField emailField;

    @FXML
    public void initialize() throws FileNotFoundException {
        Image baner = new Image(new FileInputStream("images/baner_white.png"));
        logoImage.setImage(baner);

    }

    @FXML
    public void registerButtonClick(ActionEvent actionEvent) {
        String newUsername = usernameField.getText();
        String newPassword = passwordField.getText();
        String confirmPassword = passwordConfirmField.getText();
        String newEmail = emailField.getText();
        boolean error=false;



        if(newUsername.isEmpty()){System.out.println("Username jest pusty");error=true;}
        if(newEmail.isEmpty()){System.out.println("Email jest pusty");error=true;}
        else if (!ValidationUtility.isValidEmail(newEmail)) {System.out.println("Niepoprawny adres e-mail. Upewnij się, że zawiera znak '@' oraz poprawną nazwę domeny (np. example.com)");error=true;}
        if(newPassword.isEmpty()){System.out.println("Hasło jest puste");error=true;}
        else if (!ValidationUtility.isValidPassword(newPassword)){System.out.println("Hasło powinno zawierać co najmniej 8 znaków, w tym przynajmniej jedną wielką literę, jedną małą literę, jedną cyfrę oraz jeden znak specjalny ");error=true;}
        if(confirmPassword.isEmpty()){System.out.println("Potwierdzenie hasła jest puste"); error=true;}
        else if(!newPassword.equals(confirmPassword)){System.out.println("Wpisano nie poprawne confirm Password");error=true;}

        System.out.println("\n\n");
        if(error) return;


        System.out.println("Working");
    }

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) GoBackButton.getScene().getWindow();
        PageMenagerUtility.goToLoginPage(stage);

    }
}
