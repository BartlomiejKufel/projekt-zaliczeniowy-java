package com.crowdle.model;

import jakarta.persistence.*;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "gameHistory")
public class GameHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"gameId\"")
    private int gameId;

    @Column(name = "\"gameDate\"")
    private LocalDate gameDate;
    private int scorepoint;

    @Column(name = "\"questionScore\"")
    private int questionScore;

    @Column(name = "\"playerAnswers\"")
    private int playerAnswers;

    @ManyToOne
    @JoinColumn(name = "playerId")
    private Users player;

    @ManyToOne
    @JoinColumn(name = "gameDifficultyId")
    private GameDifficulty difficulty;


    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public LocalDate getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }

    public int getScorepoint() {
        return scorepoint;
    }

    public void setScorepoint(int scorepoint) {
        this.scorepoint = scorepoint;
    }

    public int getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(int questionScore) {
        this.questionScore = questionScore;
    }

    public int getPlayerAnswers() {
        return playerAnswers;
    }

    public void setPlayerAnswers(int playerAnswers) {
        this.playerAnswers = playerAnswers;
    }

    public Users getPlayer() {
        return player;
    }

    public void setPlayer(Users player) {
        this.player = player;
    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }
}

