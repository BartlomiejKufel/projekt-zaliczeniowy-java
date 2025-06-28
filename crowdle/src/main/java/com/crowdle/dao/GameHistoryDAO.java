package com.crowdle.dao;

import com.crowdle.model.GameHistory;
import com.crowdle.model.Ranking;
import com.crowdle.model.Users;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;
/***********************************************************
 Klasa: GameHistoryDAO
 Info: Klasa posiada wszystkie potrzebne metody związane z poleceniami na tabeli gameHistory w bazie danych
 Metody:
 — public — static void — addGame(Users player, boolean result, int points, double score, int difficultyId)
 — public — static int — gameCount(int gameId)
 — public — static int — gameCount(int playerId, boolean result)
 ************************************************************/
public class GameHistoryDAO {

    /***********************************************************
     Metoda: addGame
     Typ Zwracany: void
     Info: Metoda dodaje nową grę, jaką zagrał gracz do tabeli gameHistory
     Argumenty:
     — Users player — id gracza
     — boolean result — wynik gry true-wygrana/false-przegrana
     — int points — ilość punktów, jaką gracz stracił/zyskał po tej grze
     — double score — ilość pytań, na którą gracz odpowiedział poprawnie
     — int difficultyId — tryb gry
     ************************************************************/
    public static void addGame(Users player, boolean result, int points, double score, int difficultyId){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            GameHistory game = new GameHistory();
            game.setGameDate(LocalDate.now());
            game.setResult(result);
            game.setPointsGained(points);
            game.setPlayer(player);
            game.setScorepoint(score);
            game.setDifficulty(GameDifficultyDAO.getGameDifficulty(difficultyId));
            session.beginTransaction();
            session.persist(game);
            session.getTransaction().commit();
        }
    }

    /***********************************************************
     Metoda: gameCount
     Typ Zwracany: int
     Info: Metoda zwraca ilość gier, jaką zagrał gracz
     Argumenty:
     — int gameId — id gracza
     ************************************************************/
    public static int gameCount(int gameId){
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            String query ="from GameHistory where player.userId = :id";
            List<GameHistory> gamehistory = session.createQuery(query, GameHistory.class)
                    .setParameter("id", gameId)
                    .getResultList();

            if (gamehistory.isEmpty()) {
                return 0;
            }

            return gamehistory.size();
        }
    }

    /***********************************************************
     Metoda: gameCount
     Typ Zwracany: int
     Info: Metoda zwraca ilość gier, jaką zagrał gracz o podanym wyniku wygrana/przegrana
     Argumenty:
     — int playerId — id gracza
     — boolean result — wynik gry, true-wygrana/ false-przegrana
     ************************************************************/
    public static int gameCount(int playerId, boolean result){
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            String query ="from GameHistory where player.userId = :id and result = :result";
            List<GameHistory> gamehistory = session.createQuery(query, GameHistory.class)
                    .setParameter("id", playerId)
                    .setParameter("result", result)
                    .getResultList();

            if (gamehistory.isEmpty()) {
                return 0;
            }

            return gamehistory.size();
        }
    }


}
