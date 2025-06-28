package com.crowdle.dao;

import com.crowdle.model.Questions;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;
import java.util.List;

/***********************************************************
 Klasa: QuestionsDAO
 Info: Klasa posiada wszystkie potrzebne metody związane z poleceniami na tabeli questions w bazie danych
 Metody:
 — public — static void — addQuestion(Questions question)
 — public — static List<Questions> — getRandomQuestions(int howMuch, int difficultyId)
 ************************************************************/
public class QuestionsDAO {

    /***********************************************************
     Metoda: addQuestion
     Typ Zwracany: void
     Info: Metoda dodająca nowe pytanie do tabeli questions
     Argumenty:
     — Questions question
     ************************************************************/
    public static void addQuestion(Questions question){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            session.beginTransaction();
            session.persist(question);
            session.getTransaction().commit();
        }
    }

    /***********************************************************
     Metoda: getRandomQuestions
     Typ Zwracany: List<Questions>
     Info: Metoda zwracająca listę losowych pytań z tabeli questions o wybranym poziomie trudności
     Argumenty:
     — int howMuch — ilość pytań do wylosowania
     — int difficultyId — poziom trudności wylosowanych pytań
     ************************************************************/
    public static List<Questions> getRandomQuestions(int howMuch, int difficultyId){
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            String query ="FROM Questions where difficulty.gameDifficultyId = :difficulty ORDER BY random()";
            List<Questions> questions = session.createQuery(query, Questions.class)
                    .setParameter("difficulty", difficultyId)
                    .setMaxResults(howMuch)
                    .getResultList();
            if (questions.isEmpty()) {
                return null;
            }

            return questions;
        }
    }

}
