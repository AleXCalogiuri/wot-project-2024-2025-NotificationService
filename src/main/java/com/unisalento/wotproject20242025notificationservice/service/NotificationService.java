package com.unisalento.wotproject20242025notificationservice.service;

import com.unisalento.wotproject20242025notificationservice.components.NotificationBusiness;
import com.unisalento.wotproject20242025notificationservice.domain.Notification;
import com.unisalento.wotproject20242025notificationservice.dto.NotificationDTO;
import com.unisalento.wotproject20242025notificationservice.repositories.NotificationAdminRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class NotificationService {


    private final NotificationBusiness notificationBusiness = new NotificationBusiness();
    private final NotificationAdminRepository notificationAdminRepository;

    public NotificationService(NotificationAdminRepository notificationAdminRepository) {
        this.notificationAdminRepository = notificationAdminRepository;
    }

    public List<NotificationDTO> deleteNotify(NotificationDTO notificationDTO) {
        Optional<Notification> notification = notificationAdminRepository.findById(notificationDTO.getId());
        if (notification.isEmpty()) {
            return null;
        }
        notificationAdminRepository.deleteById(notificationDTO.getId());
        return getNotificationDTOS();
    }

    public List<NotificationDTO> getNotificaDtoList(){
        return getNotificationDTOS();
    }

    private List<NotificationDTO> getNotificationDTOS() {
        List<Notification> notifications = notificationAdminRepository.findByType("admin");
        List<NotificationDTO> notificationDTOS = new ArrayList<>();
        for (Notification notificationFind : notifications){
            NotificationDTO notDTO = notificationBusiness.toNotificationDto(notificationFind);
            notificationDTOS.add(notDTO);
        }
        return notificationDTOS;
    }
}
