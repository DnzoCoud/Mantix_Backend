package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.MachineStatusDTO;
import com.gategroup.mantix_api.domain.models.MachineStatus;

public class MachineStatusMapper {
    public static MachineStatusDTO toDto(MachineStatus machineStatus) {
        MachineStatusDTO machineStatusDto = new MachineStatusDTO();
        machineStatusDto.setId(machineStatus.getId());
        machineStatusDto.setName(machineStatus.getName());
        return machineStatusDto;
    }

}
