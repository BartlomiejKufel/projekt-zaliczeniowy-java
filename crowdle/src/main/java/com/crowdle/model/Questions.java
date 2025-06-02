package com.crowdle.model;

import com.crowdle.dao.GameDifficultyDAO;
import com.crowdle.dao.TopicsDAO;
import jakarta.persistence.*;



@Entity
@Table(name = "questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"questionId\"")
    private int questionId;

    @Column(nullable = false, length = 255)
    private String content;

    @Column(name = "\"answerA\"")
    private String answerA;

    @Column(name = "\"answerB\"")
    private String answerB;

    @Column(name = "\"answerC\"")
    private String answerC;

    @Column(name = "\"answerD\"")
    private String answerD;

    @Column(name = "\"correctAnswer\"")
    private String correctAnswer;

    @ManyToOne
    @JoinColumn(name = "\"topicId\"")
    private Topics topic;

    @ManyToOne
    @JoinColumn(name = "\"difficultyId\"")
    private GameDifficulty difficulty;

    public Questions(String content, String answerA, String answerB, String answerC, String answerD, String correctAnswer, int topicId, int difficultyId) {
        this.content = content;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
        this.topic = TopicsDAO.getTopic(topicId);
        this.difficulty = GameDifficultyDAO.getGameDifficulty(difficultyId);
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Topics getTopic() {
        return topic;
    }

    public void setTopic(Topics topic) {
        this.topic = topic;
    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "questionId=" + questionId +
                ", content='" + content + '\'' +
                ", answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                ", answerD='" + answerD + '\'' +
                ", correctAnswer=" + correctAnswer +
                ", topic=" + topic.getTopicId() +
                ", difficulty=" + difficulty.getGameDifficultyId() +
                '}';
    }
}

