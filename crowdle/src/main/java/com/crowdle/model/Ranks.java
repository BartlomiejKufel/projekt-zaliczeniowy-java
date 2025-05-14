package com.crowdle.model;
import jakarta.persistence.*;



@Entity
@Table(name = "ranks")
public class Ranks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"rankId\"")
    private int rankId;

    private int requirement;
    private String name;

    @Column(name = "\"lossPoints\"")
    private int lossPoints;

    @Column(name = "\"winPoints\"")
    private int winPoints;

    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    public int getRequirement() {
        return requirement;
    }

    public void setRequirement(int requirement) {
        this.requirement = requirement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLossPoints() {
        return lossPoints;
    }

    public void setLossPoints(int lossPoints) {
        this.lossPoints = lossPoints;
    }

    public int getWinPoints() {
        return winPoints;
    }

    public void setWinPoints(int winPoints) {
        this.winPoints = winPoints;
    }
}

