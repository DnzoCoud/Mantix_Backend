package com.dnzocoud.mantix_api.application.usecases.company;

import java.util.Optional;

import com.dnzocoud.mantix_api.application.dto.CompanyDTO;
import com.dnzocoud.mantix_api.application.dto.request.StoreCompanyRequestDTO;
import com.dnzocoud.mantix_api.application.mappers.CompanyMapper;
import com.dnzocoud.mantix_api.domain.models.City;
import com.dnzocoud.mantix_api.domain.models.Company;
import com.dnzocoud.mantix_api.domain.models.Country;
import com.dnzocoud.mantix_api.domain.models.Department;
import com.dnzocoud.mantix_api.domain.services.ICityService;
import com.dnzocoud.mantix_api.domain.services.ICompanyService;
import com.dnzocoud.mantix_api.domain.services.ICountryService;
import com.dnzocoud.mantix_api.domain.services.IDepartmentService;

public class StoreCompany {
    private final ICompanyService companyService;
    private final ICountryService countryService;
    private final IDepartmentService departmentService;
    private final ICityService cityService;

    public StoreCompany(
            ICompanyService companyService,
            ICountryService countryService,
            IDepartmentService departmentService,
            ICityService cityService) {
        this.companyService = companyService;
        this.countryService = countryService;
        this.departmentService = departmentService;
        this.cityService = cityService;
    }

    public CompanyDTO execute(StoreCompanyRequestDTO storeCompanyRequest) {
        Optional<Country> countryExists = countryService.find(storeCompanyRequest.countryId());
        Optional<Department> departmentExists = departmentService.find(storeCompanyRequest.departmentId());
        Optional<City> cityExists = cityService.find(storeCompanyRequest.cityId());

        if (!countryExists.isPresent()) {
        }
        if (!departmentExists.isPresent()) {
        }
        if (!cityExists.isPresent()) {
        }
        Company companyToSave = new Company(
                null,
                storeCompanyRequest.name(),
                storeCompanyRequest.sector(),
                storeCompanyRequest.ubication(),
                storeCompanyRequest.status(),
                storeCompanyRequest.configuration(),
                countryExists.get(),
                cityExists.get(),
                departmentExists.get());
        companyToSave = companyService.store(companyToSave);
        return CompanyMapper.toDto(companyToSave);
    }
}
