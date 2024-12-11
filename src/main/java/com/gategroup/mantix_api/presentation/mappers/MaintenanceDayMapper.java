package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.MaintenanceDayDTO;
import com.gategroup.mantix_api.domain.models.MaintenanceDay;

public class MaintenanceDayMapper {
    public static MaintenanceDayDTO toDto(MaintenanceDay maintenanceDay) {
        MaintenanceDayDTO maintenanceDayDto = new MaintenanceDayDTO();
        maintenanceDayDto.setId(maintenanceDay.getId());
        maintenanceDayDto.setDate(maintenanceDay.getDate());
        maintenanceDayDto.setStatus(maintenanceDay.isStatus());
        maintenanceDayDto.setCompany(CompanyMapper.toDto(maintenanceDay.getCompany()));
        maintenanceDayDto.setSubCompany(SubcompanyMapper.toDto(maintenanceDay.getSubCompany()));
        return maintenanceDayDto;
    }
}
