package com.springmicroservices.boards.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Card {
    @Id
    private Integer id;
    @Transient
    private String title;
    @Transient
    private String description;
    @Transient
    private String participants;

    protected Card(){

    }

    public Card(String title, String description, String participants) {
        this.title = title;
        this.description = description;
        this.participants = participants;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }
}
