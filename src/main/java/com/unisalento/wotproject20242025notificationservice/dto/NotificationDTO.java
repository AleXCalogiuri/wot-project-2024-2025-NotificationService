package com.unisalento.wotproject20242025notificationservice.dto;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
    private String id;
    private String idMittente;
    private String type;
    private String message;


}
