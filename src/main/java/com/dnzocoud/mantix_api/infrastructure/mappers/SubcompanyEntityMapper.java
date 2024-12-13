package com.dnzocoud.mantix_api.infrastructure.mappers;

import com.dnzocoud.mantix_api.domain.models.Subcompany;
import com.dnzocoud.mantix_api.infrastructure.entities.SubCompanyEntity;

public final class SubcompanyEntityMapper {

    public static Subcompany toDomain(SubCompanyEntity subCompanyEntity) {
        return new Subcompany(
                subCompanyEntity.getId(),
                subCompanyEntity.getName(),
                subCompanyEntity.getSector(),
                subCompanyEntity.getUbication(),
                subCompanyEntity.getStatus(),
                subCompanyEntity.getConfiguration(),
                CountryEntityMapper.toDomain(subCompanyEntity.getCountry()),
                CityEntityMapper.toDomain(subCompanyEntity.getCity()),
                DepartmentEntityMapper.toDomain(subCompanyEntity.getDepartment()),
                CompanyEntityMapper.toDomain(subCompanyEntity.getCompany()));
    }

    public static SubCompanyEntity toEntity(Subcompany subCompany) {
        SubCompanyEntity subCompanyEntity = new SubCompanyEntity();
        subCompanyEntity.setId(subCompany.getId());
        subCompanyEntity.setName(subCompany.getName());
        subCompanyEntity.setSector(subCompany.getSector());
        subCompanyEntity.setUbication(subCompany.getUbication());
        subCompanyEntity.setStatus(subCompany.getStatus());
        subCompanyEntity.setConfiguration(subCompany.getConfiguration());
        subCompanyEntity.setCompany(CompanyEntityMapper.toEntity(subCompany.getCompany()));
        subCompanyEntity.setCountry(CountryEntityMapper.toEntity(subCompany.getCountry()));
        subCompanyEntity.setCity(CityEntityMapper.toEntity(subCompany.getCity()));
        subCompanyEntity.setDepartment(DepartmentEntityMapper.toEntity(subCompany.getDepartment()));
        return subCompanyEntity;
    }
}
