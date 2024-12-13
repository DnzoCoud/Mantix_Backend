package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.MaintenanceDayDTO;
import com.dnzocoud.mantix_api.domain.models.MaintenanceDay;

public final class MaintenanceDayMapper {
    public static MaintenanceDayDTO toDto(MaintenanceDay maintenanceDay) {
        MaintenanceDayDTO maintenanceDayDto = new MaintenanceDayDTO();
        maintenanceDayDto.setId(maintenanceDay.getId());
        maintenanceDayDto.setDate(maintenanceDay.getDate());
        maintenanceDayDto.setCompleted(maintenanceDay.isCompleted());
        maintenanceDayDto.setCompany(CompanyMapper.toDto(maintenanceDay.getCompany()));
        maintenanceDayDto.setSubCompany(SubcompanyMapper.toDto(maintenanceDay.getSubCompany()));
        return maintenanceDayDto;
    }
}
