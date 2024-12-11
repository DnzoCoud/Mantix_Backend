package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.AreaDTO;
import com.gategroup.mantix_api.domain.models.Area;

public class AreaMapper {
    public static AreaDTO toDto(Area area) {
        AreaDTO areaDto = new AreaDTO();
        areaDto.setId(area.getId());
        areaDto.setName(area.getName());
        areaDto.setCompany(CompanyMapper.toDto(area.getCompany()));
        areaDto.setSubCompany(SubcompanyMapper.toDto(area.getSubCompany()));
        areaDto.setDirector(UserMapper.toDto(area.getDirector()));
        return areaDto;
    }
}
