package com.crowdle.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;


/***********************************************************
 Klasa: Users
 Info: Model tabeli z bazy danych o nazwie Users
 Pola:
 — private — int — userId
 — private — String — username
 — private — String — password
 — private — String — email
 — private — TimeStamp — createdAt
 — private — boolean — isAdmin
 Metody:
 — Gettery i Settery dla powyższych pól
 — Metoda toString()
 ************************************************************/


@Entity
@Table(name = "users")
public class Users {

    @Column(name = "\"userId\"")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, length = 50,  name = "username")
    private String username;

    @Column(nullable = false, length = 255, name = "email")
    private String email;

    @Column(nullable = false, length = 30, name = "password")
    private String password;

    @Column(name = "\"createdAt\"")
    private Timestamp createdAt;

    @Column(nullable = false, name = "\"isAdmin\"")
    private boolean isAdmin;

    public Users() {
    }


    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //metoda pomagająca wyświetlać dane w TableView na stronie admina
    public String getCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return createdAt.toLocalDateTime().format(formatter)+" r";
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    //metoda pomagająca wyświetlać dane w TableView na stronie admina
    public String getIsAdmin() {return isAdmin ? "TAK" : "NIE";}


    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

}
