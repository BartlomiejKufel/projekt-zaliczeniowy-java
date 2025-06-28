package com.crowdle.dao;

/***********************************************************
 Klasa: RankingDTO
 Info: Model z 3 tabel z bazy danych o nazwie users, ranking i ranks
 Pola:
 — private — String — username
 — private — String — name — nazwa rangi
 — private — int — points — ilość punktów rankingowych

 Metody:
 — Gettery i Settery dla powyższych pól
 — Metoda toString()
 ************************************************************/
public class RankingDTO {
    private String username;
    private String name;
    private int points;


    public RankingDTO(String username,  int rankPoints, String rankName) {
        this.username = username;
        this.name = rankName;
        this.points = rankPoints;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "RankingDTO{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}
