package com.unisalento.wotproject20242025notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationListDTO {
    private List<NotificationDTO> notificationDTOList;
}
