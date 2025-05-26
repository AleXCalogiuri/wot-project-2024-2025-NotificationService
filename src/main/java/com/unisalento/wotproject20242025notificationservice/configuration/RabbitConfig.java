package com.unisalento.wotproject20242025notificationservice.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    public static final String NOT_ADMIN = "not-admin";
    public static final String ADD_OPERATORE = "addnew-operatore";
    public static final String ADD_ENTE = "addnew-ente";
    public static final String UPDATE_USER = "updateUser";




    @Bean
    public Queue notAdmins(){
        return new Queue(NOT_ADMIN, false);
    }

    @Bean
    public Queue addnewOperatore(){
        return new Queue(ADD_OPERATORE, false);
    }

    @Bean
    public Queue addnewEnte(){
        return new Queue(ADD_ENTE, false);
    }

    @Bean
    public Queue updateUser(){return new Queue(UPDATE_USER, false);}


}

