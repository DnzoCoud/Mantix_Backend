package com.dnzocoud.mantix_api.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dnzocoud.mantix_api.application.usecases.country.GetCountryById;
import com.dnzocoud.mantix_api.domain.services.ICountryService;

@Configuration
public class CountryUseCaseConfig {
    private final ICountryService countryService;

    @Autowired
    public CountryUseCaseConfig(ICountryService countryService) {
        this.countryService = countryService;
    }

    @Bean
    public GetCountryById getCountryById() {
        return new GetCountryById(countryService);
    }
}
