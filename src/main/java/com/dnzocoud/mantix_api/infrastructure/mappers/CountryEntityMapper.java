package com.dnzocoud.mantix_api.infrastructure.mappers;

import com.dnzocoud.mantix_api.domain.models.Country;
import com.dnzocoud.mantix_api.infrastructure.entities.CountryEntity;

public class CountryEntityMapper {
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
