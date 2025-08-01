package com.unisalento.wotproject20242025notificationservice.components;


import com.unisalento.wotproject20242025notificationservice.configuration.RabbitTopicConfig;
import com.unisalento.wotproject20242025notificationservice.domain.Notification;
import com.unisalento.wotproject20242025notificationservice.dto.NotificationDTO;
import com.unisalento.wotproject20242025notificationservice.repositories.NotificationAdminRepository;
import com.unisalento.wotproject20242025notificationservice.repositories.NotificationUserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber {

    @Autowired
    NotificationBusiness notificationBusiness;

    @Autowired
    NotificationAdminRepository notificationAdminRepository;


    @RabbitListener(queues = RabbitTopicConfig.QUEUE_ERROR_LOGS)
    public void receiveErrorLogs(String message) {
        System.out.println("Messaggio ricevuto da queue-error-logs: " + message);
    }

    @RabbitListener(queues = RabbitTopicConfig.QUEUE_ALL_LOGS)
    public void receiveAllLogs(String message) {
        System.out.println("Messaggio ricevuto da queue-all-logs: " + message);
    }

    @RabbitListener(queues = RabbitTopicConfig.NOTIFY_SENSOR_ANOMALIES)
    public void receiveSensorAnomalies(String message) {
        System.out.println("Messaggio ricevuto da sensor-anomalies: " + message);
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setMessage(message);
        notificationDTO.setIdMittente("ente");
        notificationDTO.setType("ente");
        Notification notification = notificationBusiness.toNotifica(notificationDTO);
        notification.setLetta(false);
        notificationAdminRepository.save(notification);

    }

}