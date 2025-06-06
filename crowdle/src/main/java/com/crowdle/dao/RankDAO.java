package com.crowdle.dao;

import com.crowdle.model.Ranking;
import com.crowdle.model.Ranks;
import com.crowdle.model.Users;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.query.Page;

import java.util.List;

public class RankDAO {


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

    //true - win, false - lose
    public static int RankCheckIn(Ranking playerRanking, boolean gameResult){
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
