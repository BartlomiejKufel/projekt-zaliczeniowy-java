package com.crowdle.controller;

import com.crowdle.ApplicationInfo;
import com.crowdle.dao.*;
import com.crowdle.model.GameHistory;
import com.crowdle.model.Questions;
import com.crowdle.model.Ranking;
import com.crowdle.utility.HibernateUtility;
import com.crowdle.utility.PageMenagerUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class GamePageController {
    @FXML public GridPane root;
    @FXML public ImageView iconImageView;
    @FXML public Button CButton;
    @FXML public Button AButton;
    @FXML public Button BButton;
    @FXML public Button DButton;
    @FXML public Label questionLabel;
    @FXML public ProgressBar gameProgressBar;
    @FXML public Label progressLabel;
    @FXML public Label topicLabel;
    private int index=0;
    private List<Questions> questions;
    private int goodAnswers=0;
    private int diffiluty =1;
    final private int howMuch =20;

    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);
    }

    @FXML
    public void hardButtonClick(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();

        if(index < questions.size()-1){
            if(checkAnswer(clickedButton)){goodAnswers++;}
            index++;
            setQuestionText();
        }
        else{
            Ranking player =RankingDAO.getPlayer(ApplicationInfo.LoggedUserId);

            double result = (double) goodAnswers/howMuch;
            int points;
            if(result < ApplicationInfo.VictoryThreshold && player.getPoints()==0) {points = 0;}
            else if(result >= ApplicationInfo.VictoryThreshold){points = player.getRank().getWinPoints();}
            else {points = player.getRank().getLossPoints();}

            RankingDAO.UpdatePlayerRanking(player.getPlayerId(), player.getPoints()+points, RankDAO.RankCheckIn(player, (points > 0)));
            GameHistoryDAO.addGame(UsersDAO.getUser(player.getPlayerId()),(points > 0), points, result,diffiluty);

            if(PageMenagerUtility.ScoreWindow(goodAnswers, howMuch, points)){
                Stage stage = (Stage) clickedButton.getScene().getWindow();
                PageMenagerUtility.goToStartPage(stage);
            }
            System.out.println();
        }

    }


    private void setQuestionText(){
        Questions question = questions.get(index);
        AButton.setText(question.getAnswerA());
        BButton.setText(question.getAnswerB());
        CButton.setText(question.getAnswerC());
        DButton.setText(question.getAnswerD());

        topicLabel.setText(question.getTopic().getName());
        questionLabel.setText(question.getContent()+"?");
        double progression = ((double) 1 /howMuch);
        gameProgressBar.setProgress(gameProgressBar.getProgress()+progression);
        progressLabel.setText((index+1)+"/"+howMuch);
    }

    private boolean checkAnswer(Button clickedButton){
        char answer = questions.get(index).getCorrectAnswer().charAt(0);
        return (answer==(clickedButton.getId().charAt(0)));
    }

    public void setDifficulty(int selectedDifficulty) {
        diffiluty = selectedDifficulty;
        questions = QuestionsDAO.getRandomQuestions(howMuch, diffiluty);
        setQuestionText();
    }
}
