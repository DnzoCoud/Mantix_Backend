package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.LocationDTO;
import com.gategroup.mantix_api.domain.models.Location;

public class LocationMapper {
    public static LocationDTO toDto(Location location) {
        LocationDTO locationDto = new LocationDTO();
        locationDto.setId(location.getId());
        locationDto.setName(location.getName());
        locationDto.setArea(AreaMapper.toDto(location.getArea()));
        locationDto.setManager(UserMapper.toDto(location.getManager()));
        return locationDto;
    }
}
