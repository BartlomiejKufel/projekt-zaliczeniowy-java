package com.crowdle.dao;

import com.crowdle.model.Ranking;
import com.crowdle.model.Ranks;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;

import java.util.List;
/***********************************************************
 Klasa: RankDAO
 Info: Klasa posiada wszystkie potrzebne metody związane z poleceniami na tabeli ranks w bazie danych
 Metody:
 — public — static List<Ranks> — getRanks()
 — public — static int — rankCheckIn(Ranking playerRanking, boolean gameResult)
 ************************************************************/
public class RankDAO {

    /***********************************************************
     Metoda: getRanks
     Typ Zwracany: List<Ranks>
     Info: Metoda zwraca listę wszystkich rang z tabeli ranks
     ************************************************************/
    public static List<Ranks> getRanks(){
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            List<Ranks> ranks = session.createQuery("From Ranks", Ranks.class)
                    .getResultList();

            if (ranks.isEmpty()) {
                return null;
            }

            return ranks;
        }
    }


    /***********************************************************
     Metoda: rankCheckIn
     Typ Zwracany: int
     Info: Metoda, która sprawdza, w jakiej randze użytkownik powinien znaleźć się po grze, którą wygrał/przegrał.
     Argumenty:
     — Ranking playerRanking
     — boolean gameResult — true-gra wygrana, false-gra przegrana
     ************************************************************/
    public static int rankCheckIn(Ranking playerRanking, boolean gameResult){
        int CheckedRankId =1;
        List<Ranks> ranks = getRanks();
        if(ranks == null || ranks.isEmpty())return -1;
        int newPoints=0;
        if(gameResult){
            newPoints=playerRanking.getPoints()+playerRanking.getRank().getWinPoints();
        }else{
            newPoints=playerRanking.getPoints()+playerRanking.getRank().getLossPoints();
        }

        for (Ranks rk: ranks) {
            if(newPoints >= rk.getRequirement()) CheckedRankId=rk.getRankId();
        }
        return CheckedRankId;
    }

}
