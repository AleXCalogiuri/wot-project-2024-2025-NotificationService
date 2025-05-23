package com.unisalento.wotproject20242025notificationservice.components;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber {


    @RabbitListener(queues = com.unisalento.wotproject20242025notificationservice.configuration.RabbitTopicConfig.QUEUE_ERROR_LOGS)
    public void receiveErrorLogs(String message) {
        System.out.println("Messaggio ricevuto da queue-error-logs: " + message);
    }

    @RabbitListener(queues = com.unisalento.wotproject20242025notificationservice.configuration.RabbitTopicConfig.QUEUE_ALL_LOGS)
    public void receiveAllLogs(String message) {
        System.out.println("Messaggio ricevuto da queue-all-logs: " + message);
    }

}