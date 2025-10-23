package com.unisalento.wotproject20242025notificationservice.restcontrollers;

import com.unisalento.wotproject20242025notificationservice.domain.Notification;
import com.unisalento.wotproject20242025notificationservice.domain.NotificationUser;
import com.unisalento.wotproject20242025notificationservice.dto.NotificationDTO;
import com.unisalento.wotproject20242025notificationservice.repositories.NotificationAdminRepository;
import com.unisalento.wotproject20242025notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/getNotification")
public class NotificationRestController {

    @Autowired
    NotificationAdminRepository notificationAdminRepository;

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public List<NotificationDTO> getNotify() {
        return notificationService.getNotificaDtoList();
    }

    @RequestMapping(value= ("/delete"), method = RequestMethod.POST)
    public List<NotificationDTO> deleteNotify(NotificationDTO notificationDTO) {
//        Optional<Notifica> notification = notificationAdminRepository.findById(notificationDTO.getId());
//        if (notification.isEmpty()) {
//            return null;
//        }
//        notificationAdminRepository.deleteById(notificationDTO.getId());
        return notificationService.deleteNotify(notificationDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void setAdminIsLetta(@PathVariable String id) {
        notificationService.setAdminIsLetta(id);
    }

    @RequestMapping(value = "/personal/{id}", method = RequestMethod.GET)
    public void setUserIsLetta(@PathVariable String id) {
        notificationService.setUserIsLetta(id);
    }





}

