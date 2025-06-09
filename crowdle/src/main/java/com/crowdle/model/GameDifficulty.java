package com.crowdle.model;

import jakarta.persistence.*;

/***********************************************************
 Klasa: GameDifficulty
 Info: Model tabeli z bazy danych o nazwie GameDifficulty
 Pola:
 — private — int — gameDifficultyId
 — private — String — name
 Metody:
 — Gettery i Settery dla powyższych pól
 ************************************************************/

@Entity
@Table(name = "gameDifficulty")
public class GameDifficulty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"gameDifficultyId\"")
    private int gameDifficultyId;

    private String name;


    public int getGameDifficultyId() {
        return gameDifficultyId;
    }

    public void setGameDifficultyId(int gameDifficultyId) {
        this.gameDifficultyId = gameDifficultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

