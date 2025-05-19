package com.crowdle.controls;

import com.crowdle.model.Users;
import com.crowdle.utility.ApplicationInfo;
import com.crowdle.utility.PageMenager;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;


public class LoginPageController {
    @FXML
    public PasswordField passwordField;
    public TextField usernameField;
    public ImageView logoImage;
    public CheckBox keepLoggedCheckBox;
    public GridPane root;
    public Button LoginButton;


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
    protected void LoginSubmitButtonClick(){
        String usernameToCheck = usernameField.getText();
        String passwordToCheck = passwordField.getText();

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String query = "FROM Users WHERE username = :username AND password = :password";
        List<Users> users = session.createQuery(query, Users.class)
                .setParameter("username", usernameToCheck)
                .setParameter("password", passwordToCheck)
                .getResultList();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        if(!users.isEmpty()) {
            System.out.println("Zalogowano pomyślnie");
            ApplicationInfo.LoggedUserId = users.getFirst().getUserId();
            Stage stage = (Stage) LoginButton.getScene().getWindow();
            PageMenager.GoToStartPage(stage);

        }else{
            System.out.println("Błąd logowania");
        }

    }
}