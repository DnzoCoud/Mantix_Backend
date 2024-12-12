package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.CityDTO;
import com.gategroup.mantix_api.domain.models.City;
import com.gategroup.mantix_api.infrastructure.entities.CityEntity;

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

    public static City toDomain(CityEntity cityEntity) {
        return new City(
                cityEntity.getId(),
                cityEntity.getName(),
                cityEntity.getCode(),
                CountryMapper.toDomain(cityEntity.getCountry()),
                DepartmentMapper.toDomain(cityEntity.getDepartment()));
    }

    public static CityEntity toEntity(City city) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId(city.getId());
        cityEntity.setName(city.getName());
        cityEntity.setCode(city.getCode());
        cityEntity.setCountry(CountryMapper.toEntity(city.getCountry()));
        cityEntity.setDepartment(DepartmentMapper.toEntity(city.getDepartment()));
        return cityEntity;
    }
}
