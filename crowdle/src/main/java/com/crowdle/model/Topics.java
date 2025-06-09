package com.crowdle.model;
import jakarta.persistence.*;

/***********************************************************
 Klasa: Topics
 Info: Model tabeli z bazy danych o nazwie Topics
 Pola:
 — private — int — topicId
 — private — String — name
 Metody:
 — Gettery i Settery dla powyższych pól
 ************************************************************/

@Entity
@Table(name = "topics")
public class Topics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"topicId\"")
    private int topicId;

    @Column(nullable = false, length = 50)
    private String name;


    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
