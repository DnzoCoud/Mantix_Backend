package com.gategroup.mantix_api.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gategroup.mantix_api.application.usecases.company.FindAllCompanies;
import com.gategroup.mantix_api.application.usecases.company.StoreCompany;
import com.gategroup.mantix_api.domain.services.ICityService;
import com.gategroup.mantix_api.domain.services.ICompanyService;
import com.gategroup.mantix_api.domain.services.ICountryService;
import com.gategroup.mantix_api.domain.services.IDepartmentService;

@Configuration
public class CompanyUseCaseConfig {
    private final ICompanyService companyService;
    private final ICountryService countryService;
    private final IDepartmentService departmentService;
    private final ICityService cityService;

    public CompanyUseCaseConfig(
            ICompanyService companyService,
            ICountryService countryService,
            IDepartmentService departmentService,
            ICityService cityService) {
        this.companyService = companyService;
        this.countryService = countryService;
        this.departmentService = departmentService;
        this.cityService = cityService;
    }

    @Bean
    public StoreCompany storeCompany() {
        return new StoreCompany(companyService, countryService, departmentService, cityService);
    }

    @Bean
    public FindAllCompanies findAllCompanies() {
        return new FindAllCompanies(companyService);
    }
}
