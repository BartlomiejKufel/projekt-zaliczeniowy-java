package com.crowdle.dao;

import com.crowdle.model.GameDifficulty;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;

public class GameDifficultyDAO {

    public static GameDifficulty getGameDifficulty(int id){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            return session.find(GameDifficulty.class, id);
        }
    }

}
