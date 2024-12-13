package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.MachineStatusDTO;
import com.dnzocoud.mantix_api.domain.models.MachineStatus;

public final class MachineStatusMapper {
    public static MachineStatusDTO toDto(MachineStatus machineStatus) {
        MachineStatusDTO machineStatusDto = new MachineStatusDTO();
        machineStatusDto.setId(machineStatus.getId());
        machineStatusDto.setName(machineStatus.getName());
        return machineStatusDto;
    }

}
