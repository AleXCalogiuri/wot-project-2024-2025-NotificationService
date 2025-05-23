package com.unisalento.wotproject20242025notificationservice.repositories;

import com.unisalento.wotproject20242025notificationservice.domain.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;
import java.util.Optional;

public interface NotificationAdminRepository extends MongoRepository<Notification, String> {
    List<Notification> findByType(String type);
    Optional<Notification> findByMessage(String message);
    Optional<Notification> findByIdMittente(String notifyIdMittente);

}
