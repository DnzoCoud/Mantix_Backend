package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.CompanyDTO;
import com.gategroup.mantix_api.domain.models.Company;
import com.gategroup.mantix_api.infrastructure.entities.CompanyEntity;

public final class CompanyMapper {
    public static CompanyDTO toDto(Company company) {
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

    public static Company toDomain(CompanyEntity companyEntity) {
        return new Company(
                companyEntity.getId(),
                companyEntity.getName(),
                companyEntity.getSector(),
                companyEntity.getUbication(),
                companyEntity.getStatus(),
                companyEntity.getConfiguration(),
                CountryMapper.toDomain(companyEntity.getCountry()),
                CityMapper.toDomain(companyEntity.getCity()),
                DepartmentMapper.toDomain(companyEntity.getDepartment()));
    }

    public static CompanyEntity toEntity(Company company) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(company.getId());
        companyEntity.setName(company.getName());
        companyEntity.setSector(company.getSector());
        companyEntity.setStatus(company.getStatus());
        companyEntity.setUbication(company.getUbication());
        companyEntity.setConfiguration(company.getConfiguration());
        companyEntity.setCountry(CountryMapper.toEntity(company.getCountry()));
        companyEntity.setDepartment(DepartmentMapper.toEntity(company.getDepartment()));
        companyEntity.setCity(CityMapper.toEntity(company.getCity()));
        return companyEntity;
    }
}
