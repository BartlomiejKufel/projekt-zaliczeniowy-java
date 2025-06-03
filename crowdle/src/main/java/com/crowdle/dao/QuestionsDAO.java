package com.crowdle.dao;

import com.crowdle.model.Questions;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;
import java.util.List;

public class QuestionsDAO {

    public static void addQuestion(Questions question){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            session.beginTransaction();
            session.persist(question);
            session.getTransaction().commit();
        }
    }

    public static List<Questions> getRandomQuestions(int howMuch){
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            String query ="FROM Questions order by random() limit :number";
            List<Questions> questions = session.createQuery(query, Questions.class)
                    .setParameter("number", howMuch)
                    .getResultList();

            if (questions.isEmpty()) {
                return null;
            }

            return questions;
        }

    }

}
