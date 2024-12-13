package com.dnzocoud.mantix_api.application.usecases.country;

import com.dnzocoud.mantix_api.domain.exceptions.ResourceNotFoundException;
import com.dnzocoud.mantix_api.domain.models.Country;
import com.dnzocoud.mantix_api.domain.services.ICountryService;

public class GetCountryById {
    private final ICountryService countryService;

    public GetCountryById(ICountryService countryService) {
        this.countryService = countryService;
    }

    public Country execute(Long id) {
        return countryService.find(id).orElseThrow(() -> new ResourceNotFoundException(
                String.format("Pais no existe o no se encuentra con el id: %s", id)));
    }
}
