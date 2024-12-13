package com.dnzocoud.mantix_api.infrastructure.mappers;

import com.dnzocoud.mantix_api.domain.models.City;
import com.dnzocoud.mantix_api.infrastructure.entities.CityEntity;

public class CityEntityMapper {
    public static City toDomain(CityEntity cityEntity) {
        return new City(
                cityEntity.getId(),
                cityEntity.getName(),
                cityEntity.getCode(),
                CountryEntityMapper.toDomain(cityEntity.getCountry()),
                DepartmentEntityMapper.toDomain(cityEntity.getDepartment()));
    }

    public static CityEntity toEntity(City city) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId(city.getId());
        cityEntity.setName(city.getName());
        cityEntity.setCode(city.getCode());
        cityEntity.setCountry(CountryEntityMapper.toEntity(city.getCountry()));
        cityEntity.setDepartment(DepartmentEntityMapper.toEntity(city.getDepartment()));
        return cityEntity;
    }
}
