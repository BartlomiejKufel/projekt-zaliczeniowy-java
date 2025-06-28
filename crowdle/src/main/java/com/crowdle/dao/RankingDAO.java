package com.crowdle.dao;

import com.crowdle.model.Ranking;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;

import java.util.List;
/***********************************************************
 Klasa: RankingDAO
 Info: Klasa posiada wszystkie potrzebne metody związane z poleceniami na tabeli ranking w bazie danych
 Metody:
 — public — static List<RankingDTO> — getRanking()
 — public — static Ranking — getPlayer(int id)
 — public — static Ranking — updatePlayerRanking(int userId, int points, int rankId)
 ************************************************************/
public class RankingDAO {

    /***********************************************************
     Metoda: getRanking
     Typ Zwracany: List<RankingDTO>
     Info: Metoda zwracająca listę wszystkich graczy w rankingu
     ************************************************************/
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

    /***********************************************************
     Metoda: getPlayer
     Typ Zwracany: Ranking
     Info: Metoda zwracająca gracza w rankingu o podanym id
     Argumenty:
     — int id — id gracza
     ************************************************************/
    public static Ranking getPlayer(int id){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            return session.find(Ranking.class, id);
        }
    }

    /***********************************************************
     Metoda: updatePlayerRanking
     Typ Zwracany: void
     Info: Metoda nadająca nowe wartości rekordowi o podanym id w tabeli ranking
     Argumenty:
     — int userId — id gracza w tabeli
     — int points — ilość punktów
     — int rankId — id rangi
     ************************************************************/
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
