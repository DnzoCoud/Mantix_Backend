package com.dnzocoud.mantix_api.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dnzocoud.mantix_api.application.usecases.city.GetCityById;
import com.dnzocoud.mantix_api.domain.services.ICityService;

@Configuration
public class CityUseCaseConfig {

    private final ICityService cityService;

    @Autowired
    public CityUseCaseConfig(ICityService cityService) {
        this.cityService = cityService;
    }

    @Bean
    public GetCityById getCityById() {
        return new GetCityById(cityService);
    }
}
