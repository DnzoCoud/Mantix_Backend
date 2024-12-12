package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.CountryDTO;
import com.gategroup.mantix_api.domain.models.Country;
import com.gategroup.mantix_api.infrastructure.entities.CountryEntity;

public class CountryMapper {
    public static CountryDTO toDto(Country country) {
        CountryDTO countryDto = new CountryDTO();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        countryDto.setCode(country.getCode());
        return countryDto;
    }

    public static Country toDomain(CountryEntity countryEntity) {
        return new Country(countryEntity.getId(), countryEntity.getName(), countryEntity.getCode());
    }

    public static CountryEntity toEntity(Country country) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(country.getId());
        countryEntity.setName(country.getName());
        countryEntity.setCode(country.getCode());
        return countryEntity;
    }
}
