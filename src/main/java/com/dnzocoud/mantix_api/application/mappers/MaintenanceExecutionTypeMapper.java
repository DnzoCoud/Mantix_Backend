package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.MaintenanceExecutionTypeDTO;
import com.dnzocoud.mantix_api.domain.models.MaintenanceExecutionType;

public final class MaintenanceExecutionTypeMapper {
    public static MaintenanceExecutionTypeDTO toDto(MaintenanceExecutionType maintenanceExecutionType) {
        MaintenanceExecutionTypeDTO maintenanceExecutionTypeDto = new MaintenanceExecutionTypeDTO();
        maintenanceExecutionTypeDto.setId(maintenanceExecutionType.getId());
        maintenanceExecutionTypeDto.setName(maintenanceExecutionType.getName());
        maintenanceExecutionTypeDto.setCode(maintenanceExecutionType.getCode());
        return maintenanceExecutionTypeDto;
    }
}
