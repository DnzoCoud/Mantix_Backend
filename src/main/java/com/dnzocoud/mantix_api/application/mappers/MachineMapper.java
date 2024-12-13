package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.MachineDTO;
import com.dnzocoud.mantix_api.domain.models.Machine;

public final class MachineMapper {
    public static MachineDTO toDto(Machine machine) {
        MachineDTO machineDto = new MachineDTO();
        machineDto.setId(machine.getId());
        machineDto.setName(machine.getName());
        machineDto.setModel(machine.getModel());
        machineDto.setSerial(machine.getSerial());
        machineDto.setLocation(LocationMapper.toDto(machine.getLocation()));
        return machineDto;
    }
}
