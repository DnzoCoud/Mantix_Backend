package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.CountryDTO;
import com.gategroup.mantix_api.domain.models.Country;

public class CountryMapper {
    public static CountryDTO toDto(Country country) {
        CountryDTO countryDto = new CountryDTO();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        countryDto.setCode(country.getCode());
        return countryDto;
    }
}
