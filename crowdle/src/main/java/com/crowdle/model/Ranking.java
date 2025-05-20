package com.crowdle.model;
import jakarta.persistence.*;



@Entity
@Table(name = "ranking")
public class Ranking {

    @Id
    @Column(name = "\"playerId\"")
    private int playerId;

    @OneToOne
    @JoinColumn(name = "\"playerId\"", referencedColumnName = "userId", insertable = false, updatable = false)
    private Users player;

    @Column(nullable = false)
    private int points;

    @ManyToOne
    @JoinColumn(name = "\"rankId\"")
    private Ranks rank;


    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Users getPlayer() {
        return player;
    }

    public void setPlayer(Users player) {
        this.player = player;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Ranks getRank() {
        return rank;
    }

    public void setRank(Ranks rank) {
        this.rank = rank;
    }
}

