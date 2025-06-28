package com.crowdle.dao;

import com.crowdle.model.Topics;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;
/***********************************************************
 Klasa: TopicsDAO
 Info: Klasa posiada wszystkie potrzebne metody związane z poleceniami na tabeli topics w bazie danych
 Metody:
 — public — static Topics — getTopic(int id)
 ************************************************************/
public class TopicsDAO {

    /***********************************************************
     Metoda: getTopic
     Typ Zwracany: Topics
     Info: Metoda zwracająca temat z tabeli topics o podanym id
     Argumenty:
     — int id — id tematu
     ************************************************************/
    public static Topics getTopic(int id){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            return session.find(Topics.class, id);
        }
    }

}
