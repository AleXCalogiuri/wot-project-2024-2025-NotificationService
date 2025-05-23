package com.unisalento.wotproject20242025notificationservice.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unisalento.wotproject20242025notificationservice.configuration.RabbitConfig;
import com.unisalento.wotproject20242025notificationservice.domain.Notification;
import com.unisalento.wotproject20242025notificationservice.domain.NotificationUser;
import com.unisalento.wotproject20242025notificationservice.dto.NotificationDTO;
import com.unisalento.wotproject20242025notificationservice.repositories.NotificationAdminRepository;
import com.unisalento.wotproject20242025notificationservice.repositories.NotificationUserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.Optional;


@Component
public class MessageListener {
    @Autowired
    ObjectMapper jacksonObjectMapper;

    @Autowired
    NotificationAdminRepository notificationAdminRepository;

    @Autowired
    NotificationUserRepository notificationUserRepository;

    @Autowired
    NotificationBusiness notificationBusiness;

    @RabbitListener(queues = RabbitConfig.NOT_ADMIN)
    public void receiveMessage(String message){
        Optional<Notification> existingNotification = notificationAdminRepository.findByMessage(message);
        if(existingNotification.isPresent()){
            return;
        }
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setMessage(message);
        notificationDTO.setIdMittente("pub");
        notificationDTO.setType("admin");
        Notification notification = notificationBusiness.toNotifica(notificationDTO);
        notificationAdminRepository.save(notification);
    }

    @RabbitListener(queues = RabbitConfig.ADD_OPERATORE)
    public void addArtist(String message){
        Optional<Notification> existingNotification = notificationAdminRepository.findByMessage(message);
        if (existingNotification.isPresent()){
            return;
        }
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setMessage(message);
        notificationDTO.setIdMittente("operatore");
        notificationDTO.setType("admin");
        Notification notification = notificationBusiness.toNotifica(notificationDTO);
        notificationAdminRepository.save(notification);
    }


    @RabbitListener(queues = RabbitConfig.UPDATE_USER)
    public void updateUser(String idUser) throws JsonProcessingException {
        String message = "UPDATE ACCOUNT";
        NotificationUser notification = new NotificationUser();
        notification.setMessage(message);
        notification.setIdMittente("MUSIC VIRUS");
        notification.setType(idUser);
        notification.setData(LocalDateTime.now());
        notification.setLetta(false);
        notificationUserRepository.save(notification);
    }





}