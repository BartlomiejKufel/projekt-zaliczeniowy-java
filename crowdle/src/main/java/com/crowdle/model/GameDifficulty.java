package com.crowdle.model;

import jakarta.persistence.*;

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

