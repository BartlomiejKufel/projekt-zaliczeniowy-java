package com.crowdle.controller;

import com.crowdle.ApplicationInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ScorePageController {
    @FXML public GridPane root;
    @FXML public ImageView iconImageView;
    @FXML public Button closeButton;
    @FXML public Label scoreLabel;
    @FXML public Label pointsLabel;
    @FXML public Label resultLabel;


    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);
    }


    public void closeButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }



    public void setScore(int goodAnswers, int howMuch, int points) {
        double result = (double) goodAnswers/howMuch;
        if(result >= ApplicationInfo.VictoryThreshold){
            resultLabel.setText("Wygrałeś");
            resultLabel.setStyle("-fx-text-fill: #224a32;");
            pointsLabel.setText("+"+points+" punktów");
            pointsLabel.setStyle("-fx-text-fill: #224a32;");
        }else{
            resultLabel.setText("Przegrałeś");
            resultLabel.setStyle("-fx-text-fill: #cf2121;");
            pointsLabel.setText(points+" punktów");
            pointsLabel.setStyle("-fx-text-fill: #cf2121;");
        }

        scoreLabel.setText(goodAnswers+"/"+howMuch+"\npytań");

    }
}
