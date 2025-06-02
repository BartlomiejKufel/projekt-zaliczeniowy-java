package com.crowdle.dao;

import com.crowdle.model.Notifications;
import com.crowdle.model.Ranking;
import com.crowdle.model.Users;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.util.List;

public class NotificationsDAO {


    public static void addNotification(int userId, String title, String message){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            Notifications notification = new Notifications();
            notification.setUser(UsersDAO.getUser(userId));
            notification.setMessage(message);
            notification.setTitle(title);
            notification.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            session.beginTransaction();
            session.persist(notification);
            session.getTransaction().commit();
        }
    }

    public static List<Notifications> getNotifications(){
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            String query = "FROM Notifications n ORDER BY n.createdAt DESC";
            List<Notifications> notifications = session.createQuery(query, Notifications.class)
                    .getResultList();
            if (notifications.isEmpty()) {
                return null;
            }

            return notifications;
        }
    }



}
