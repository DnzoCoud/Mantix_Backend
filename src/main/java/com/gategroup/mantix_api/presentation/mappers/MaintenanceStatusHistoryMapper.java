package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.MaintenanceStatusHistoryDTO;
import com.gategroup.mantix_api.domain.models.MaintenanceStatusHistory;

public class MaintenanceStatusHistoryMapper {
    public static MaintenanceStatusHistoryDTO toDto(MaintenanceStatusHistory maintenanceStatusHistory) {
        MaintenanceStatusHistoryDTO maintenanceStatusHistoryDto = new MaintenanceStatusHistoryDTO();
        maintenanceStatusHistoryDto.setId(maintenanceStatusHistory.getId());
        maintenanceStatusHistoryDto.setMaintenance(MaintenanceMapper.toDto(maintenanceStatusHistory.getMaintenance()));
        maintenanceStatusHistoryDto
                .setFromStatus(MaintenanceStatusMapper.toDto(maintenanceStatusHistory.getFromStatus()));
        maintenanceStatusHistoryDto.setToStatus(MaintenanceStatusMapper.toDto(maintenanceStatusHistory.getToStatus()));
        maintenanceStatusHistoryDto.setChangedByUser(UserMapper.toDto(maintenanceStatusHistory.getChangedByUser()));
        return maintenanceStatusHistoryDto;
    }
}
