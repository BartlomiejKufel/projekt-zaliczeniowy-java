package com.crowdle.dao;

import com.crowdle.model.Questions;
import com.crowdle.model.Ranking;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;

import java.sql.Timestamp;

public class QuestionsDAO {

    public static void addQuestion(Questions question){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            session.beginTransaction();
            session.persist(question);
            session.getTransaction().commit();
        }
    }

}
