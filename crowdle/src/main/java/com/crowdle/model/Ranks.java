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

    public String getRankImg(){
        switch (rankId){
            case 1: return "images/ranks/rankLogo1.png";
            case 2: return "images/ranks/rankLogo2.png";
            case 3: return "images/ranks/rankLogo3.png";
            case 4: return "images/ranks/rankLogo4.png";
            case 5: return "images/ranks/rankLogo5.png";
            case 6: return "images/ranks/rankLogo6.png";
            case 7: return "images/ranks/rankLogo7.png";
            case 8: return "images/ranks/rankLogo8.png";
            case 9: return "images/ranks/rankLogo9.png";
            case 10: return "images/ranks/rankLogo10.png";

            default: return "";
        }
    }
}

