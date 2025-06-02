package com.crowdle.controller;

import com.crowdle.dao.QuestionsDAO;
import com.crowdle.model.Questions;
import com.crowdle.utility.CsvUtility;
import com.crowdle.utility.PageMenagerUtility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AdminPageQuestionsController {
    @FXML public GridPane root;
    @FXML public ImageView iconImageView;
    @FXML public Button notificationButton;
    @FXML public Button userButton;
    @FXML public Button backButton;
    @FXML public Button goToNotificationButton;
    @FXML public Button choiceButton;
    @FXML public Button saveButton;
    @FXML public Label saveLabel;
    @FXML public ListView<Questions> questionsListView;
    private List<Questions> questions;

    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);

        saveLabel.setVisible(false);
    }

    @FXML
    public void backButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        PageMenagerUtility.goToStartPage(stage);
    }

    @FXML
    public void notificationAdminButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) goToNotificationButton.getScene().getWindow();
        PageMenagerUtility.goToAdminNotificationPage(stage);
    }


    @FXML
    public void usersButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) userButton.getScene().getWindow();
        PageMenagerUtility.goToAdminPage(stage);
    }

    @FXML
    public void notificationButtonClick(ActionEvent actionEvent) {
        PageMenagerUtility.goToNotificationWindow();
    }

    @FXML
    public void choiceButtonClick(ActionEvent actionEvent) {
        saveLabel.setVisible(false);
        if(questions != null && !questions.isEmpty()) questions.clear();

        Stage stage = (Stage) choiceButton.getScene().getWindow();
        questions = CsvUtility.loadQuestionsFromCSV(stage);

        refresh();
    }

    @FXML
    public void saveButtonClick(ActionEvent actionEvent) {
        if(!questions.isEmpty()){
            for (Questions qs: questions){
                QuestionsDAO.addQuestion(qs);
            }

            saveLabel.setText("Zapisano "+ questions.size() +" pytań do bazy");
            saveLabel.setVisible(true);
            questions.clear();
            refresh();
        }
    }

    private void refresh(){
        ObservableList<Questions> observableQuestions = FXCollections.observableArrayList(questions);
        questionsListView.setItems(observableQuestions);
    }
}
