package com.crowdle.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/***********************************************************
 Klasa: HibernateUtility
 Info: Klasa odpowiedzialna za przechowywanie funkcji związanych z Hibernate
 Pola:
 — private — static final SessionFactory — sessionFactory
 Metody:
 — public — static SessionFactory — getSessionFactory()
 — public — static void — shutdown()
 ************************************************************/
public class HibernateUtility {
    private static final SessionFactory sessionFactory;

    static {
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();

        }catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }

    //Getter do pola sessionFactory
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    /***********************************************************
     Klasa: shutdown
     Typ Zwracany: void
     Info: Zakończenie połączenia z bazą danych
     ************************************************************/
    public static void shutdown(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }
}
