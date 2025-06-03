package com.crowdle.controller;

import com.crowdle.ApplicationInfo;
import com.crowdle.model.Ranking;
import com.crowdle.utility.HibernateUtility;
import com.crowdle.utility.PageMenagerUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GamemodePageController {
    @FXML public GridPane root;
    @FXML public ImageView rankImage;
    @FXML public Label rankLabel;
    @FXML public Label rankPointsLabel;
    @FXML public Label usernameLabel;
    @FXML public Button backButton;
    @FXML public Button hardButton;
    @FXML public Button advanceButton;
    @FXML public Button easyButton;
    @FXML public ImageView iconImageView;
    @FXML public Button notificationButton;

    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);

        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            Ranking userInformation = session.find(Ranking.class, ApplicationInfo.LoggedUserId);
            Image rankImg = new Image(new FileInputStream(userInformation.getRank().getRankImg()));
            rankImage.setImage(rankImg);
            rankLabel.setText(userInformation.getRank().getName());
            rankPointsLabel.setText(userInformation.getPoints()+" CP");
            usernameLabel.setText(userInformation.getPlayer().getUsername());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void notificationButtonClick(ActionEvent actionEvent) {
        PageMenagerUtility.goToNotificationWindow();
    }

    public void easyButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        PageMenagerUtility.goToGamePage(stage);
    }

    public void advanceButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        PageMenagerUtility.goToGamePage(stage);
    }

    public void hardButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        PageMenagerUtility.goToGamePage(stage);
    }

    public void backButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        PageMenagerUtility.goToStartPage(stage);
    }
}
