package com.crowdle.controller;

import com.crowdle.model.Ranking;
import com.crowdle.ApplicationInfo;
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

public class StartPageController {

    @FXML public Button logoutButton;
    @FXML public Label rankLabel;
    @FXML public Label rankPointsLabel;
    @FXML public Label usernameLabel;
    @FXML public Button gameButton;
    @FXML public Button rankingButton;
    @FXML public Button settingButton;
    @FXML public ImageView rankImage;
    @FXML public Button adminButton;
    @FXML public Button notificationButton;
    @FXML public GridPane root;
    @FXML public ImageView iconImageView;

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
            if(userInformation.getPlayer().isAdmin()){
                adminButton.setVisible(true);
            }else{
                adminButton.setVisible(false);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    public void logoutButtonClick() {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        PageMenagerUtility.goToLoginPage(stage);
    }

    @FXML
    public void settingButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) settingButton.getScene().getWindow();
        PageMenagerUtility.goToSettingsPage(stage);
    }

    @FXML
    public void rankingButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) rankingButton.getScene().getWindow();
        PageMenagerUtility.goToRankingPage(stage);

    }

    @FXML
    public void adminButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) rankingButton.getScene().getWindow();
        PageMenagerUtility.goToAdminPage(stage);

    }

    @FXML
    public void playButtonClick(ActionEvent actionEvent) {
        //select * from topics order by random() limit 2 może się przydać do znajdywania pytań

    }
}
