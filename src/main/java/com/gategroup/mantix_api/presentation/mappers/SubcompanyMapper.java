package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.SubcompanyDTO;
import com.gategroup.mantix_api.domain.models.Subcompany;
import com.gategroup.mantix_api.infrastructure.entities.SubCompanyEntity;

public class SubcompanyMapper {
    public static SubcompanyDTO toDto(Subcompany subCompany) {
        SubcompanyDTO subcompanyDto = new SubcompanyDTO();
        subcompanyDto.setId(subCompany.getId());
        subcompanyDto.setName(subCompany.getName());
        subcompanyDto.setSector(subCompany.getSector());
        subcompanyDto.setStatus(subCompany.getStatus());
        subcompanyDto.setUbication(subCompany.getUbication());
        subcompanyDto.setConfiguration(subCompany.getConfiguration());
        subcompanyDto.setCountry(CountryMapper.toDto(subCompany.getCountry()));
        subcompanyDto.setCity(CityMapper.toDto(subCompany.getCity()));
        subcompanyDto.setDepartment(DepartmentMapper.toDto(subCompany.getDepartment()));
        return subcompanyDto;
    }

    public static Subcompany toDomain(SubCompanyEntity subCompanyEntity) {
        return new Subcompany(
                subCompanyEntity.getId(),
                subCompanyEntity.getName(),
                subCompanyEntity.getSector(),
                subCompanyEntity.getUbication(),
                subCompanyEntity.getStatus(),
                subCompanyEntity.getConfiguration(),
                CountryMapper.toDomain(subCompanyEntity.getCountry()),
                CityMapper.toDomain(subCompanyEntity.getCity()),
                DepartmentMapper.toDomain(subCompanyEntity.getDepartment()),
                CompanyMapper.toDomain(subCompanyEntity.getCompany()));
    }
}
