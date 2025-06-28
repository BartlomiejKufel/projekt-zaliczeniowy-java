package com.crowdle.dao;

import com.crowdle.model.GameDifficulty;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;


/***********************************************************
 Klasa: GameDifficultyDAO
 Info: Klasa posiada wszystkie potrzebne metody związane z poleceniami na tabeli gamedifficulty w bazie danych
 Metody:
 — public — static GameDifficulty — getGameDifficulty(int id)
 ************************************************************/
public class GameDifficultyDAO {

    /***********************************************************
     Metoda: getGameDifficulty
     Typ Zwracany: GameDifficulty
     Info: Metoda zwracająca rekord z tabeli gamedifficulty o podanym id
     Argumenty:
     — int id — id rekordu z tabeli gamedifficulty
     ************************************************************/
    public static GameDifficulty getGameDifficulty(int id){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            return session.find(GameDifficulty.class, id);
        }
    }

}
