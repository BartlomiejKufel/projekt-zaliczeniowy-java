package com.crowdle.dao;

import com.crowdle.model.Ranking;
import com.crowdle.model.Users;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;

import java.sql.Timestamp;
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

    public static List<Users> getUsers(){
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            List<Users> users = session.createQuery("From Users", Users.class)
                    .getResultList();

            if (users.isEmpty()) {
                return null;
            }

            return users;
        }
    }

    public static Users getUser(int id){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            return session.find(Users.class, id);
        }
    }


    public static void addUser(String newUsername, String newEmail, String newPassword){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            Users user = new Users();
            user.setUsername(newUsername);
            user.setEmail(newEmail);
            user.setPassword(newPassword);
            user.setAdmin(false);
            user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();

            //Dodanie rankingu użytkownikowi
            session.beginTransaction();
            Ranking userRanking = new Ranking();
            userRanking.setPlayerId(user.getUserId());
            userRanking.setPoints(0);
            userRanking.setRankId(1);
            session.persist(userRanking);
            session.getTransaction().commit();
        }
    }


    public static void updateUser(int id, String newUsername, String newEmail, String newPassword) {
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            String query ="UPDATE Users SET username = :username, email = :email, password = :password WHERE userId = :id";
            session.beginTransaction();
            session.createQuery(query)
                    .setParameter("username", newUsername)
                    .setParameter("password", newPassword)
                    .setParameter("email", newEmail)
                    .setParameter("id", id)
                    .executeUpdate();

            session.getTransaction().commit();
        }
    }


    public static void deleteUser(int id){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            session.beginTransaction();
            Users user = session.find(Users.class, id);
            Ranking player = RankingDAO.getPlayer(id);
            if (player != null) {
                session.remove(player);
                if (user != null) {
                    session.getTransaction().commit();
                    session.beginTransaction();
                    session.remove(user);
                }
            }

            session.getTransaction().commit();
        }
    }
}
