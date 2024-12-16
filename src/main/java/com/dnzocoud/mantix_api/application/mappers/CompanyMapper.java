package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.CompanyDTO;
import com.dnzocoud.mantix_api.domain.models.Company;

public final class CompanyMapper {
    public static CompanyDTO toDto(Company company) {
        if (company == null)
            return null;

        CompanyDTO companyDto = new CompanyDTO();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setSector(company.getSector());
        companyDto.setStatus(company.getStatus());
        companyDto.setUbication(company.getUbication());
        companyDto.setConfiguration(company.getConfiguration());
        companyDto.setCountry(CountryMapper.toDto(company.getCountry()));
        companyDto.setDepartment(DepartmentMapper.toDto(company.getDepartment()));
        companyDto.setCity(CityMapper.toDto(company.getCity()));
        return companyDto;
    }
}
