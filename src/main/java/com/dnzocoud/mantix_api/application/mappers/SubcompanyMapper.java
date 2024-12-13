package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.SubcompanyDTO;
import com.dnzocoud.mantix_api.domain.models.Subcompany;

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
    
}
