package com.gategroup.mantix_api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MaintenanceStatusHistoryDTO {
    private Long id;
    private MaintenanceDTO maintenance;
    private MaintenanceStatusDTO fromStatus;
    private MaintenanceStatusDTO toStatus;
    private UserDTO changedByUser;
}
