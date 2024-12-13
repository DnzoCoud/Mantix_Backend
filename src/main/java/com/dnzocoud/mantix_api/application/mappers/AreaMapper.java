package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.AreaDTO;
import com.dnzocoud.mantix_api.domain.models.Area;

public final class AreaMapper {
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
