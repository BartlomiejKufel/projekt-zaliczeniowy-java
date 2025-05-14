package com.crowdle.model;

import jakarta.persistence.*;



@Entity
@Table(name = "playerAnswers")
public class PlayerAnswers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"playerAnswersId\"")
    private int playerAnswersId;

    @Column(nullable = false, length = 50, name = "\"playerAnswers\"")
    private String playerAnswers;

    @Column(nullable = false, length = 50, name = "\"answersCheck\"")
    private String answersCheck;


    public int getPlayerAnswersId() {
        return playerAnswersId;
    }

    public void setPlayerAnswersId(int playerAnswersId) {
        this.playerAnswersId = playerAnswersId;
    }

    public String getPlayerAnswers() {
        return playerAnswers;
    }

    public void setPlayerAnswers(String playerAnswers) {
        this.playerAnswers = playerAnswers;
    }

    public String getAnswersCheck() {
        return answersCheck;
    }

    public void setAnswersCheck(String answersCheck) {
        this.answersCheck = answersCheck;
    }
}

