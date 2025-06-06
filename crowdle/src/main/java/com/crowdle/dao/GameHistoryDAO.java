package com.crowdle.dao;

import com.crowdle.model.GameHistory;
import com.crowdle.model.Ranking;
import com.crowdle.model.Users;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class GameHistoryDAO {
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
