package com.crowdle;

import com.crowdle.model.Users;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;


public class LoginController {
    @FXML
    public PasswordField passwordField;
    public TextField usernameField;
    public ImageView logoImage;
    public CheckBox keepLoggedCheckBox;
    public GridPane root;


    @FXML
    //Metoda która uruchamia się odrazu po uruchomieniu
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
        boolean keepLogged = keepLoggedCheckBox.isSelected();

        System.out.println(usernameToCheck+";"+passwordToCheck+";"+keepLogged);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        List<Users> users = session.createQuery("FROM Users", Users.class).getResultList();
        users.forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}