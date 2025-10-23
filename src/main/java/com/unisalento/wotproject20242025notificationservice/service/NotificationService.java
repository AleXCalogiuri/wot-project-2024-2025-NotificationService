package com.unisalento.wotproject20242025notificationservice.service;

import com.unisalento.wotproject20242025notificationservice.components.NotificationBusiness;
import com.unisalento.wotproject20242025notificationservice.domain.Notification;
import com.unisalento.wotproject20242025notificationservice.domain.NotificationUser;
import com.unisalento.wotproject20242025notificationservice.dto.NotificationDTO;
import com.unisalento.wotproject20242025notificationservice.repositories.NotificationAdminRepository;
import com.unisalento.wotproject20242025notificationservice.repositories.NotificationUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class NotificationService {


    private final NotificationBusiness notificationBusiness = new NotificationBusiness();
    private final NotificationAdminRepository notificationAdminRepository;
    private final NotificationUserRepository notificationUserRepository;

    public NotificationService(NotificationAdminRepository notificationAdminRepository, NotificationUserRepository notificationUserRepository) {
        this.notificationAdminRepository = notificationAdminRepository;
        this.notificationUserRepository = notificationUserRepository;
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

    public void setAdminIsLetta(String id){
        Optional<Notification> notification = notificationAdminRepository.findById(id);
        if(notification.isPresent()){
            notification.get().setLetta(true);
            notificationAdminRepository.save(notification.get());
        }
    }

    public void setUserIsLetta(String id){
        Optional<NotificationUser> notification = notificationUserRepository.findById(id);
        if(notification.isPresent()){
            notification.get().setLetta(true);
            notificationUserRepository.save(notification.get());
        }
    }
}
