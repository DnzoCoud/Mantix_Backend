package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.MaintenanceDTO;
import com.dnzocoud.mantix_api.domain.models.Maintenance;

public final class MaintenanceMapper {
    public static MaintenanceDTO toDto(Maintenance maintenance) {
        MaintenanceDTO maintenanceDto = new MaintenanceDTO();
        maintenanceDto.setId(maintenance.getId());
        maintenanceDto.setUniqueNumber(maintenance.getUniqueNumber());
        maintenanceDto.setStartDate(maintenance.getStartDate());
        maintenanceDto.setEndDate(maintenance.getEndDate());
        maintenanceDto.setDescription(maintenance.getDescription());
        maintenanceDto.setDamageCauses(maintenance.getDamageCauses());
        maintenanceDto.setRecommendations(maintenance.getRecommendations());
        maintenanceDto.setObservations(maintenance.getObservations());
        maintenanceDto.setMachine(MachineMapper.toDto(maintenance.getMachine()));
        maintenanceDto.setMaintenanceStatus(MaintenanceStatusMapper.toDto(maintenance.getMaintenanceStatus()));
        maintenanceDto.setMaintenanceDay(MaintenanceDayMapper.toDto(maintenance.getMaintenanceDay()));
        maintenanceDto.setExecutionType(MaintenanceExecutionTypeMapper.toDto(maintenance.getExecutionType()));
        maintenanceDto.setCompany(CompanyMapper.toDto(maintenance.getCompany()));
        maintenanceDto.setSubCompany(SubcompanyMapper.toDto(maintenance.getSubCompany()));
        return maintenanceDto;
    }
}
