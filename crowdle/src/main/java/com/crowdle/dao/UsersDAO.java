package com.crowdle.dao;

import com.crowdle.model.Ranking;
import com.crowdle.model.Users;
import com.crowdle.utility.HibernateUtility;
import org.hibernate.Session;
import java.sql.Timestamp;
import java.util.List;

/***********************************************************
 Klasa: UsersDAO
 Info: Klasa posiada wszystkie potrzebne metody związane z poleceniami na tabeli users w bazie danych
 Metody:
 — public — static Users — getUser(String username, String password)
 — public — static List<Users> — getUsers()
 — public — static Users — getUser(int id)
 — public — static void — addUser(String newUsername, String newEmail, String newPassword)
 — public — static void — updateUser(int id, String newUsername, String newEmail, String newPassword)
 — public — static void — deleteUser(int id)
 — public — static boolean — isUsernameInDB(String username)
 — public — static boolean — isEmailInDB(String email)
 ************************************************************/
public class UsersDAO {

    /***********************************************************
     Metoda: getUser
     Typ Zwracany: Users
     Info: Metoda, która zwraca użytkownika o podanym username i haśle użytkownika
     Argumenty:
     -String username
     -String password
     ************************************************************/
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

    /***********************************************************
     Metoda: getUser
     Typ Zwracany: List<Users>
     Info: Metoda, która zwraca listę wszystkich użytkowników
     ************************************************************/
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

    /***********************************************************
     Metoda: getUser
     Typ Zwracany: Users
     Info: Metoda, która zwraca użytkownika o podanym id użytkownika
     Argumenty:
     -int id
     ************************************************************/
    public static Users getUser(int id){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            return session.find(Users.class, id);
        }
    }

    /***********************************************************
     Metoda: addUser
     Typ Zwracany: void
     Info: Metoda, która najpierw dodaje nowego użytkownika, a następnie po jego identyfikatorze dodaje go do tabeli Ranking
     Argumenty:
     -String newUsername
     -String newEmail
     -String newPassword
     ************************************************************/
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

    /***********************************************************
     Metoda: updateUser
     Typ Zwracany: void
     Info: Metoda ustawia nowe wartości w rekordzie o podanym id w tabeli users
     Argumenty:
     -int id — id użytkownika
     -String newUsername — nazwa użytkownika
     -String newEmail — email
     -String newPassword — hasło
     ************************************************************/
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

    /***********************************************************
     Metoda: deleteUser
     Typ Zwracany: void
     Info: Metoda usuwa rekord o podanym id z tabeli users i ranking
     Argumenty:
     -int id — id użytkownika
     ************************************************************/
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


    /***********************************************************
     Metoda: isUsernameInDB
     Typ Zwracany: boolean
     Info: Metoda sprawdza, czy w tabeli users istnieje rekor z podanym usernamem
     Argumenty:
     -String username — username do sprawdzenia
     ************************************************************/
    public static boolean isUsernameInDB(String username){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            String query = "FROM Users WHERE username = :username";
            List<Users> users = session.createQuery(query, Users.class)
                    .setParameter("username", username)
                    .getResultList();

            if (users.isEmpty()) {
                return false;
            }
            return true;
        }
    }

    /***********************************************************
     Metoda: isEmailInDB
     Typ Zwracany: boolean
     Info: Metoda sprawdza, czy w tabeli users istnieje rekor z podanym emailem
     Argumenty:
     -String email — email do sprawdzenia
     ************************************************************/
    public static boolean isEmailInDB(String email){
        try(Session session = HibernateUtility.getSessionFactory().openSession()){
            String query = "FROM Users WHERE email = :email";
            List<Users> users = session.createQuery(query, Users.class)
                    .setParameter("email", email)
                    .getResultList();

            if (users.isEmpty()) {
                return false;
            }
            return true;
        }
    }
}
