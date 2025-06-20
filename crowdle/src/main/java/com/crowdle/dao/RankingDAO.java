package com.crowdle.dao;

import com.crowdle.model.Ranking;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;

import java.util.List;

public class RankingDAO {

    public static List<RankingDTO> getRanking(){
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            String query ="SELECT new com.crowdle.dao.RankingDTO(u.username, r.points, rn.name) FROM Ranking r JOIN r.player u JOIN r.rank rn ORDER BY r.points DESC";
            List<RankingDTO> ranking = session.createQuery(query, RankingDTO.class).getResultList();

            if (ranking.isEmpty()) {
                return null;
            }

            return ranking;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Ranking getPlayer(int id){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            return session.find(Ranking.class, id);
        }
    }

    public static void updatePlayerRanking(int userId, int points, int rankId){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            String query ="UPDATE Ranking SET  points = :points, rankId = :rank WHERE playerId = :id";
            session.beginTransaction();
            session.createQuery(query)
                    .setParameter("points", points)
                    .setParameter("rank", rankId)
                    .setParameter("id", userId)
                    .executeUpdate();

            session.getTransaction().commit();
        }
    }

}
