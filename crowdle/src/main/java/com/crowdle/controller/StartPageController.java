package com.crowdle.controller;

import com.crowdle.model.Ranking;
import com.crowdle.ApplicationInfo;
import com.crowdle.utility.HibernateUtility;
import com.crowdle.utility.PageMenagerUtility;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.hibernate.Session;

public class StartPageController {

    @FXML public Button logoutButton;
    @FXML public Label rankLabel;
    @FXML public Label rankPointsLabel;
    @FXML public Label usernameLabel;
    @FXML public Button gameButton;
    @FXML public Button rankingButton;
    @FXML public Button settingButton;

    @FXML
    public void initialize() {

        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            Ranking userInformation = session.find(Ranking.class, ApplicationInfo.LoggedUserId);
            rankLabel.setText(userInformation.getRank().getName());
            rankPointsLabel.setText(String.valueOf(userInformation.getPoints()));
            usernameLabel.setText(userInformation.getPlayer().getUsername());
        }

    }


    @FXML
    public void LogoutButtonClick() {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        PageMenagerUtility.GoToLoginPage(stage);
    }
}
