package com.unisalento.wotproject20242025notificationservice.repositories;

import com.unisalento.wotproject20242025notificationservice.domain.NotificationUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationUserRepository extends MongoRepository<NotificationUser, String> {
    List<NotificationUser> findByType(String type);
    Optional<NotificationUser> findByMessage(String message);
    Optional<NotificationUser> findById(String id);
}
