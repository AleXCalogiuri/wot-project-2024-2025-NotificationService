package com.unisalento.wotproject20242025notificationservice.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("notificationUser")
public class NotificationUser {

    @Id
    private String id;
    private String idMittente;
    private String email;
    private String type;
    private String message;
    private boolean letta;
    private LocalDateTime data;

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean isLetta() {
        return letta;
    }

    public void setLetta(boolean letta) {
        this.letta = letta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdMittente() {
        return idMittente;
    }

    public void setIdMittente(String idMittente) {
        this.idMittente = idMittente;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
