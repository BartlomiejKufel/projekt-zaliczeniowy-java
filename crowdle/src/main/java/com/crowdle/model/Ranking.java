package com.crowdle.model;
import jakarta.persistence.*;


/***********************************************************
 Klasa: Ranking
 Info: Model tabeli z bazy danych o nazwie Ranking
 Pola:
 — private — int — playerId
 — private — Users — player
 — private — int — points
 — private — int — rankId
 — private — Ranks — rank
 Metody:
 — Gettery i Settery dla powyższych pól
 — Metoda toString()
 ************************************************************/
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

    @Column(name = "\"rankId\"")
    private int rankId;

    @ManyToOne
    @JoinColumn(name = "\"rankId\"", insertable = false, updatable = false)
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

    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "playerId=" + playerId +
                ", player=" + player +
                ", points=" + points +
                ", rankId=" + rankId +
                ", rank=" + rank +
                '}';
    }
}

