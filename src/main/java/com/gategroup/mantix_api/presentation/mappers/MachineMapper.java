package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.MachineDTO;
import com.gategroup.mantix_api.domain.models.Machine;

public class MachineMapper {
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
