package com.unisalento.wotproject20242025notificationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Document("notification")
public class Notification {

    @Id
    private String id;
    private String idMittente;
    private String email;
    private String type;
    private String message;
    private boolean letta;
    private LocalDateTime data;


}