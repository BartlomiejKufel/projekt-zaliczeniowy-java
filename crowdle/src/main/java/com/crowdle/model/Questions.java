package com.crowdle.model;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "\"correctAnswer\"")
    private CorrectAnswer correctAnswer;

    public enum CorrectAnswer {
        A, B, C, D
    }

    @ManyToOne
    @JoinColumn(name = "topicId")
    private Topics topic;

    @ManyToOne
    @JoinColumn(name = "difficultyId")
    private GameDifficulty difficulty;


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

    public CorrectAnswer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(CorrectAnswer correctAnswer) {
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
}

