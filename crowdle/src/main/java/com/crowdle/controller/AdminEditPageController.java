package com.crowdle.controller;

import com.crowdle.dao.UsersDAO;
import com.crowdle.model.Users;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AdminEditPageController {

    @FXML public GridPane root;
    @FXML public Button saveButton;
    @FXML public Button reloadButton;
    @FXML public TextField usernameField;
    @FXML public Label errorUserLabel;
    @FXML public TextField emailField;
    @FXML public Label errorMailLabel;
    @FXML public PasswordField passwordField;
    @FXML public Label errorPasswordLabel;
    @FXML public PasswordField passwordConfirmField;
    @FXML public Label errorConfirmLabel;
    @FXML public ImageView iconImageView;

    private Users selectedUser;

    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);
    }


    @FXML
    public void saveButtonClick(ActionEvent actionEvent) {
        String newUsername = usernameField.getText();
        String newPassword = passwordField.getText();
        String confirmPassword = passwordConfirmField.getText();
        String newEmail = emailField.getText();
        boolean error=false;

        if(newUsername.isEmpty()){errorUserLabel.setText("Puste pole!"); errorUserLabel.setVisible(true);error=true;}
        else if(UsersDAO.isUsernameInDB(newUsername) && !newUsername.equals(selectedUser.getUsername())) {errorUserLabel.setText("Użytkownik już istnieje!"); errorUserLabel.setVisible(true);error=true;}
        if(newEmail.isEmpty()){errorMailLabel.setText("Puste pole!");errorMailLabel.setVisible(true);error=true;}
        else if (!ValidationUtility.isValidEmail(newEmail)){errorMailLabel.setText("Niepoprawny adres e-mail! Upewnij się, że zawiera znak '@' oraz poprawną nazwę domeny (np. example.com)"); errorMailLabel.setVisible(true); error=true;}
        else if(UsersDAO.isEmailInDB(newEmail) && !newEmail.equals(selectedUser.getEmail())){errorMailLabel.setText("Taki email jest już zapisany!"); errorMailLabel.setVisible(true); error=true;}
        if(newPassword.isEmpty()){errorPasswordLabel.setText("Puste pole!");errorPasswordLabel.setVisible(true); error=true;}
        else if (!ValidationUtility.isValidPassword(newPassword)){errorPasswordLabel.setText("Hasło powinno zawierać co najmniej 8 znaków, w tym przynajmniej jedną wielką literę, jedną małą literę, jedną cyfrę oraz jeden znak specjalny!");errorPasswordLabel.setVisible(true); error=true;}
        if(confirmPassword.isEmpty()){errorConfirmLabel.setText("Puste pole!");errorConfirmLabel.setVisible(true); error=true;}
        else if(!newPassword.equals(confirmPassword)){errorConfirmLabel.setText("Błędne hasło!"); errorConfirmLabel.setVisible(true); error=true;}
        if(error) return;

        UsersDAO.updateUser(selectedUser.getUserId(), newUsername, newEmail,newPassword);

        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void reloadButtonClick(ActionEvent actionEvent) {
        reload();
    }


    public void setSelectedUser(Users user) {
        this.selectedUser = user;
        reload();
    }

    private void reload(){
        if(!(selectedUser == null)) {
            usernameField.setText(selectedUser.getUsername());
            emailField.setText(selectedUser.getEmail());
            passwordField.setText(selectedUser.getPassword());
            passwordConfirmField.setText(selectedUser.getPassword());
            errorUserLabel.setVisible(false);
            errorMailLabel.setVisible(false);
            errorPasswordLabel.setVisible(false);
            errorConfirmLabel.setVisible(false);

        }
    }
}
