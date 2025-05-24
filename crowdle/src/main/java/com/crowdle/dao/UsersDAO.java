package com.crowdle.dao;

import com.crowdle.ApplicationInfo;
import com.crowdle.model.Users;
import com.crowdle.utility.HibernateUtility;
import com.crowdle.utility.PageMenagerUtility;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UsersDAO {


    public static Users getUser(String username, String password){
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            String query = "FROM Users WHERE username = :username AND password = :password";
            List<Users> users = session.createQuery(query, Users.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getResultList();

            if (users.isEmpty()) {
                return null;
            }
            return users.getFirst();
        }
    }

    public static Users getUser(int id){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            return session.find(Users.class, id);
        }
    }


}
