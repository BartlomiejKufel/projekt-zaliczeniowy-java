package com.crowdle.controller;

import com.crowdle.ApplicationInfo;
import com.crowdle.dao.QuestionsDAO;
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

    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);

        questions = QuestionsDAO.getRandomQuestions(20);
        setQuestionText();
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
            System.out.println("Zakończono grę\nIlość dobrych odpowiedzi: "+goodAnswers);
            Stage stage = (Stage) clickedButton.getScene().getWindow();
            PageMenagerUtility.goToStartPage(stage);

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
        gameProgressBar.setProgress(gameProgressBar.getProgress()+0.05);
        progressLabel.setText((index+1)+"/20");
    }

    private boolean checkAnswer(Button clickedButton){
        char answer = questions.get(index).getCorrectAnswer().charAt(0);
        return (answer==(clickedButton.getId().charAt(0)));
    }

}
