package com.crowdle.controller;

import com.crowdle.ApplicationInfo;
import com.crowdle.dao.UsersDAO;
import com.crowdle.model.Ranking;
import com.crowdle.model.Ranks;
import com.crowdle.model.Users;
import com.crowdle.utility.HibernateUtility;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class SignUpPageController {
    @FXML public Button RegisterButton;
    @FXML public Button GoBackButton;
    @FXML public TextField usernameField;
    @FXML public PasswordField passwordField;
    @FXML public PasswordField passwordConfirmField;
    @FXML public ImageView logoImage;
    @FXML public TextField emailField;
    @FXML public GridPane root;
    @FXML public Label errorConfirmLabel;
    @FXML public Label errorPasswordLabel;
    @FXML public Label errorMailLabel;
    @FXML public Label errorUserLabel;

    @FXML
    public void initialize() throws FileNotFoundException {
        Image baner = new Image(new FileInputStream("images/baner_black.png"));
        logoImage.setImage(baner);

    }

    @FXML
    public void registerButtonClick(ActionEvent actionEvent) {
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

        UsersDAO.addUser(newUsername, newEmail,newPassword);

        Stage stage = (Stage) RegisterButton.getScene().getWindow();
        PageMenagerUtility.goToLoginPage(stage);

    }

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) GoBackButton.getScene().getWindow();
        PageMenagerUtility.goToLoginPage(stage);

    }
}
