package com.crowdle.dao;

import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;

import java.util.List;

public class RankingDAO {

    public static List<RankingDTO> getRanking(){
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            List<RankingDTO> result = session.createQuery("SELECT new com.crowdle.dao.RankingDTO(u.username, r.points, rn.name) " +
                    "FROM Ranking r JOIN r.player u JOIN r.rank rn ORDER BY r.points DESC", RankingDTO.class).getResultList();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
