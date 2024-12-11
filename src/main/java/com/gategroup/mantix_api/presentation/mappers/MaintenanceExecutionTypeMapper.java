package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.MaintenanceExecutionTypeDTO;
import com.gategroup.mantix_api.domain.models.MaintenanceExecutionType;

public class MaintenanceExecutionTypeMapper {
    public static MaintenanceExecutionTypeDTO toDto(MaintenanceExecutionType maintenanceExecutionType) {
        MaintenanceExecutionTypeDTO maintenanceExecutionTypeDto = new MaintenanceExecutionTypeDTO();
        maintenanceExecutionTypeDto.setId(maintenanceExecutionType.getId());
        maintenanceExecutionTypeDto.setName(maintenanceExecutionType.getName());
        maintenanceExecutionTypeDto.setCode(maintenanceExecutionType.getCode());
        return maintenanceExecutionTypeDto;
    }
}
