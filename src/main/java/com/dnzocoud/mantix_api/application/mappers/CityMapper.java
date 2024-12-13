package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.CityDTO;
import com.dnzocoud.mantix_api.domain.models.City;

public final class CityMapper {
    public static CityDTO toDto(City city) {
        CityDTO cityDto = new CityDTO();
        cityDto.setId(city.getId());
        cityDto.setCode(city.getCode());
        cityDto.setName(city.getName());
        cityDto.setCountry(CountryMapper.toDto(city.getCountry()));
        cityDto.setDepartment(DepartmentMapper.toDto(city.getDepartment()));
        return cityDto;
    }
}
