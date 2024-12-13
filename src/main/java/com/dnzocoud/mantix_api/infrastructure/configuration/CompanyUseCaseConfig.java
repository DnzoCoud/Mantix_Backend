package com.dnzocoud.mantix_api.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dnzocoud.mantix_api.application.usecases.city.GetCityById;
import com.dnzocoud.mantix_api.application.usecases.company.FindAllCompanies;
import com.dnzocoud.mantix_api.application.usecases.company.StoreCompany;
import com.dnzocoud.mantix_api.application.usecases.country.GetCountryById;
import com.dnzocoud.mantix_api.application.usecases.department.GetDepartmentById;
import com.dnzocoud.mantix_api.domain.services.ICompanyService;

@Configuration
public class CompanyUseCaseConfig {
    private final ICompanyService companyService;
    private final GetCountryById getCountryById;
    private final GetDepartmentById getDepartmentById;
    private final GetCityById getCityById;

    @Autowired
    public CompanyUseCaseConfig(
            ICompanyService companyService,
            GetCountryById getCountryById,
            GetDepartmentById getDepartmentById,
            GetCityById getCityById) {
        this.companyService = companyService;
        this.getCountryById = getCountryById;
        this.getDepartmentById = getDepartmentById;
        this.getCityById = getCityById;
    }

    @Bean
    public StoreCompany storeCompany() {
        return new StoreCompany(companyService, getCountryById, getCityById, getDepartmentById);
    }

    @Bean
    public FindAllCompanies findAllCompanies() {
        return new FindAllCompanies(companyService);
    }
}
