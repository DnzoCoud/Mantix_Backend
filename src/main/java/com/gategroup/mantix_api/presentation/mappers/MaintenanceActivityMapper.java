package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.MaintenanceActivityDTO;
import com.gategroup.mantix_api.domain.models.MaintenanceActivity;

public class MaintenanceActivityMapper {
    public static MaintenanceActivityDTO toDto(MaintenanceActivity maintenanceActivity) {
        MaintenanceActivityDTO maintenanceActivityDto = new MaintenanceActivityDTO();
        maintenanceActivityDto.setId(maintenanceActivity.getId());
        maintenanceActivityDto.setDescription(maintenanceActivity.getDescription());
        maintenanceActivityDto.setStartDate(maintenanceActivity.getStartDate());
        maintenanceActivityDto.setEndDate(maintenanceActivity.getEndDate());
        maintenanceActivityDto.setCompleted(maintenanceActivity.isCompleted());
        maintenanceActivityDto.setObservation(maintenanceActivity.getObservation());
        maintenanceActivityDto.setUsedSpares(maintenanceActivity.getUsedSpares());
        maintenanceActivityDto.setMaintenance(MaintenanceMapper.toDto(maintenanceActivity.getMaintenance()));
        maintenanceActivityDto.setTechnician(UserMapper.toDto(maintenanceActivity.getTechnician()));
        return maintenanceActivityDto;
    }
}
