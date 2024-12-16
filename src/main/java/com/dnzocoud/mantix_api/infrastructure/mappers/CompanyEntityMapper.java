package com.dnzocoud.mantix_api.infrastructure.mappers;

import com.dnzocoud.mantix_api.domain.models.Company;
import com.dnzocoud.mantix_api.infrastructure.entities.CompanyEntity;

public final class CompanyEntityMapper {

    public static Company toDomain(CompanyEntity companyEntity) {
        if (companyEntity == null)
            return null;
        return new Company(
                companyEntity.getId(),
                companyEntity.getName(),
                companyEntity.getSector(),
                companyEntity.getUbication(),
                companyEntity.getStatus(),
                companyEntity.getConfiguration(),
                CountryEntityMapper.toDomain(companyEntity.getCountry()),
                CityEntityMapper.toDomain(companyEntity.getCity()),
                DepartmentEntityMapper.toDomain(companyEntity.getDepartment()));
    }

    public static CompanyEntity toEntity(Company company) {
        if (company == null)
            return null;
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(company.getId());
        companyEntity.setName(company.getName());
        companyEntity.setSector(company.getSector());
        companyEntity.setStatus(company.getStatus());
        companyEntity.setUbication(company.getUbication());
        companyEntity.setConfiguration(company.getConfiguration());
        companyEntity.setCountry(CountryEntityMapper.toEntity(company.getCountry()));
        companyEntity.setDepartment(DepartmentEntityMapper.toEntity(company.getDepartment()));
        companyEntity.setCity(CityEntityMapper.toEntity(company.getCity()));
        return companyEntity;
    }
}
