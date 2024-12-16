package com.dnzocoud.mantix_api.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dnzocoud.mantix_api.application.usecases.subCompany.GetSubCompanyById;
import com.dnzocoud.mantix_api.domain.services.ISubCompanyService;

@Configuration
public class SubCompanyUseCaseConfig {
    private final ISubCompanyService subCompanyService;

    @Autowired
    public SubCompanyUseCaseConfig(ISubCompanyService subCompanyService) {
        this.subCompanyService = subCompanyService;
    }

    @Bean
    public GetSubCompanyById getSubCompanyById() {
        return new GetSubCompanyById(subCompanyService);
    }
}
