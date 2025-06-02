package com.crowdle.dao;

import com.crowdle.model.Topics;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;

public class TopicsDAO {

    public static Topics getTopic(int id){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            return session.find(Topics.class, id);
        }
    }

}
