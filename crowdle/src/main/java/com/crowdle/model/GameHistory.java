package com.crowdle.model;

import jakarta.persistence.*;
import java.time.LocalDate;



/***********************************************************
 Klasa: GameHistory
 Info: Model tabeli z bazy danych o nazwie GameHistory
 Pola:
 — private — int — gameId
 — private — LocalDate — gameDate
 — private — double — scorepoint
 — private — int — pointGained
 — private — boolean — result
 — private — Users — player
 — private — GameDifficulty — difficulty
 Metody:
 — Gettery i Settery dla powyższych pól
 ************************************************************/

@Entity
@Table(name = "gameHistory")
public class GameHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"gameId\"")
    private int gameId;

    @Column(name = "\"gameDate\"")
    private LocalDate gameDate;

    @Column(name = "scorepoint")
    private double scorepoint;

    @Column(name = "\"pointsGained\"")
    private int pointsGained;

    @Column(name="result")
    private boolean result;

    @ManyToOne
    @JoinColumn(name = "\"playerId\"")
    private Users player;

    @ManyToOne
    @JoinColumn(name = "\"gameDifficultyId\"")
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

    public double getScorepoint() {
        return scorepoint;
    }

    public void setScorepoint(double scorepoint) {
        this.scorepoint = scorepoint;
    }

    public int getPointsGained() {
        return pointsGained;
    }

    public void setPointsGained(int pointsGained) {
        this.pointsGained = pointsGained;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
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

