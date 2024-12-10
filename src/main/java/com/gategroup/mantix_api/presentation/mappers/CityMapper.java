package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.CityDTO;
import com.gategroup.mantix_api.domain.models.City;

public class CityMapper {
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
