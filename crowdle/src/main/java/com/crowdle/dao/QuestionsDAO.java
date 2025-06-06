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

    public static List<Questions> getRandomQuestions(int howMuch, int difficultyId){
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            String query ="FROM Questions where difficulty.gameDifficultyId = :difficulty ORDER BY random()";
            List<Questions> questions = session.createQuery(query, Questions.class)
                    .setParameter("difficulty", difficultyId)
//                    .setParameter("number", howMuch)
                    .setMaxResults(howMuch)
                    .getResultList();
//       WHERE "difficultyId" = :difficulty  LIMIT :number
            if (questions.isEmpty()) {
                return null;
            }

            return questions;
        }
    }

}
