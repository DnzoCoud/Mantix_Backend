package com.dnzocoud.mantix_api.presentation.mappers;

import com.dnzocoud.mantix_api.domain.models.Subcompany;
import com.dnzocoud.mantix_api.infrastructure.entities.SubCompanyEntity;

public class SubcompanyEntityMapper {

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
}
