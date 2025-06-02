package com.crowdle.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "notifications")
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"notificationId\"")
    private int notificationId;

    @ManyToOne
    @JoinColumn(name = "\"userId\"")
    private Users user;

    @Column(name = "\"createdAt\"")
    private Timestamp createdAt;


    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 255)
    private String message;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "["+createdAt.toLocalDateTime().format(formatter)+"]";
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getMessage() {
        StringBuilder result = new StringBuilder();
        int lineLength = 30;

        int lastSpace = -1;
        int lineStart = 0;

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            result.append(c);

            if (Character.isWhitespace(c)) {
                lastSpace = i;
            }

            if (i - lineStart >= lineLength) {
                if (lastSpace >= lineStart) {
                    result.setCharAt(lastSpace, '\n');
                    lineStart = lastSpace + 1;
                    lastSpace = -1;
                } else {
                    result.append('\n');
                    lineStart = i + 1;
                    lastSpace = -1;
                }
            }
        }

        return result.toString();
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
