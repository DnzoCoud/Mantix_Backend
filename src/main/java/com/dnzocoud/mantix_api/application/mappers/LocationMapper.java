package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.LocationDTO;
import com.dnzocoud.mantix_api.domain.models.Location;

public final class LocationMapper {
    public static LocationDTO toDto(Location location) {
        LocationDTO locationDto = new LocationDTO();
        locationDto.setId(location.getId());
        locationDto.setName(location.getName());
        locationDto.setArea(AreaMapper.toDto(location.getArea()));
        locationDto.setManager(UserMapper.toDto(location.getManager()));
        return locationDto;
    }
}
