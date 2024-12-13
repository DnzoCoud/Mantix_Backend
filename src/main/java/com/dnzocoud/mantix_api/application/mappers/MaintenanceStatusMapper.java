package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.MaintenanceStatusDTO;
import com.dnzocoud.mantix_api.domain.models.MaintenanceStatus;

public final class MaintenanceStatusMapper {
    public static MaintenanceStatusDTO toDto(MaintenanceStatus maintenanceStatus) {
        MaintenanceStatusDTO maintenanceStatusDto = new MaintenanceStatusDTO();
        maintenanceStatusDto.setId(maintenanceStatus.getId());
        maintenanceStatusDto.setName(maintenanceStatus.getName());
        return maintenanceStatusDto;
    }
}
