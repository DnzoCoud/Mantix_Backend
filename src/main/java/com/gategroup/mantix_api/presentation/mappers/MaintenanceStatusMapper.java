package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.MaintenanceStatusDTO;
import com.gategroup.mantix_api.domain.models.MaintenanceStatus;

public class MaintenanceStatusMapper {
    public static MaintenanceStatusDTO toDto(MaintenanceStatus maintenanceStatus) {
        MaintenanceStatusDTO maintenanceStatusDto = new MaintenanceStatusDTO();
        maintenanceStatusDto.setId(maintenanceStatus.getId());
        maintenanceStatusDto.setName(maintenanceStatus.getName());
        return maintenanceStatusDto;
    }
}
