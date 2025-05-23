package com.unisalento.wotproject20242025notificationservice.components;


import com.unisalento.wotproject20242025notificationservice.domain.Notification;
import com.unisalento.wotproject20242025notificationservice.dto.NotificationDTO;
import org.springframework.stereotype.Component;

@Component
public class NotificationBusiness {
    public NotificationDTO toNotificationDto(Notification notification){
        new NotificationDTO();
        return NotificationDTO.builder()
                .id(notification.getId())
                .message(notification.getMessage())
                .idMittente(notification.getIdMittente())
                .type(notification.getType())
                .build();
    }

    public Notification toNotifica(NotificationDTO notificationDTO){
        new Notification();
        return Notification.builder()
                .message(notificationDTO.getMessage())
                .idMittente(notificationDTO.getIdMittente())
                .type(notificationDTO.getType())
                .build();
    }
}
