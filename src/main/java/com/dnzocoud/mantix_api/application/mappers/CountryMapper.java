package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.CountryDTO;
import com.dnzocoud.mantix_api.domain.models.Country;

public final class CountryMapper {
    public static CountryDTO toDto(Country country) {
        CountryDTO countryDto = new CountryDTO();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        countryDto.setCode(country.getCode());
        return countryDto;
    }
}
