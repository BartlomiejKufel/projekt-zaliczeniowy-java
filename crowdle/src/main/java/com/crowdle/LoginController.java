package com.crowdle;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class LoginController {
    @FXML
    public PasswordField passwordField;
    public TextField usernameField;
    public ImageView logoImage;
    public CheckBox keepLoggedCheckBox;


    @FXML
    //Metoda która uruchamia się odrazu po uruchomieniu
    public void initialize() throws FileNotFoundException {
        Image img = new Image(new FileInputStream("images/baner_white.png"));
        logoImage.setImage(img);

    }

    @FXML
    protected void LoginSubmitButtonClick(){

        String usernameToCheck = usernameField.getText();
        String passwordToCheck = passwordField.getText();
        boolean keepLogged = keepLoggedCheckBox.isSelected();

        System.out.println(usernameToCheck+";"+passwordToCheck+";"+keepLogged);


    }
}