package com.dnzocoud.mantix_api.application.usecases.company;

import com.dnzocoud.mantix_api.application.dto.CompanyDTO;
import com.dnzocoud.mantix_api.application.dto.request.StoreCompanyRequestDTO;
import com.dnzocoud.mantix_api.application.mappers.CompanyMapper;
import com.dnzocoud.mantix_api.application.usecases.city.GetCityById;
import com.dnzocoud.mantix_api.application.usecases.country.GetCountryById;
import com.dnzocoud.mantix_api.application.usecases.department.GetDepartmentById;
import com.dnzocoud.mantix_api.domain.exceptions.InvalidRequestException;
import com.dnzocoud.mantix_api.domain.models.City;
import com.dnzocoud.mantix_api.domain.models.Company;
import com.dnzocoud.mantix_api.domain.models.Country;
import com.dnzocoud.mantix_api.domain.models.Department;
import com.dnzocoud.mantix_api.domain.services.ICompanyService;

public class StoreCompany {
    private final ICompanyService companyService;
    private final GetCountryById getCountryById;
    private final GetCityById getCityById;
    private final GetDepartmentById getDepartmentById;

    public StoreCompany(
            ICompanyService companyService,
            GetCountryById getCountryById,
            GetCityById getCityById,
            GetDepartmentById getDepartmentById) {
        this.companyService = companyService;
        this.getCountryById = getCountryById;
        this.getCityById = getCityById;
        this.getDepartmentById = getDepartmentById;
    }

    private static void validateRequest(final StoreCompanyRequestDTO storeCompanyRequestDto) {
        if (storeCompanyRequestDto.countryId() == null || storeCompanyRequestDto.cityId() == null
                || storeCompanyRequestDto.departmentId() == null) {
            throw new InvalidRequestException("Faltan campos obligatorios");
        }
    }

    public CompanyDTO execute(StoreCompanyRequestDTO storeCompanyRequest) {
        validateRequest(storeCompanyRequest);
        Country countryExists = getCountryById.execute(storeCompanyRequest.countryId());
        City cityExists = getCityById.execute(storeCompanyRequest.cityId());
        Department departmentExists = getDepartmentById.execute(storeCompanyRequest.departmentId());

        Company companyToSave = new Company(
                null,
                storeCompanyRequest.name(),
                storeCompanyRequest.sector(),
                storeCompanyRequest.ubication(),
                storeCompanyRequest.status(),
                storeCompanyRequest.configuration(),
                countryExists,
                cityExists,
                departmentExists);
        companyToSave = companyService.store(companyToSave);
        return CompanyMapper.toDto(companyToSave);
    }

}
