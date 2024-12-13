package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.MaintenanceActivityDTO;
import com.dnzocoud.mantix_api.domain.models.MaintenanceActivity;

public final class MaintenanceActivityMapper {
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
