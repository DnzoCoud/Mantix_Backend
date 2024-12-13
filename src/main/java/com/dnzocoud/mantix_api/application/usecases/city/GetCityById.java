package com.dnzocoud.mantix_api.application.usecases.city;

import com.dnzocoud.mantix_api.domain.exceptions.ResourceNotFoundException;
import com.dnzocoud.mantix_api.domain.models.City;
import com.dnzocoud.mantix_api.domain.services.ICityService;

public class GetCityById {
    private final ICityService cityService;

    public GetCityById(ICityService cityService) {
        this.cityService = cityService;
    }

    public City execute(Long id) {
        return cityService.find(id).orElseThrow(() -> new ResourceNotFoundException("Ciudad no existe"));
    }
}
