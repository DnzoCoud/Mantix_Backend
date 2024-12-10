package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.DepartmentDTO;
import com.gategroup.mantix_api.domain.models.Department;

public class DepartmentMapper {
    public static DepartmentDTO toDto(Department department) {
        DepartmentDTO departmentDto = new DepartmentDTO();
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        departmentDto.setCode(department.getCode());
        departmentDto.setCountry(CountryMapper.toDto(department.getCountry()));
        return departmentDto;
    }
}
