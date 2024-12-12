package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.DepartmentDTO;
import com.gategroup.mantix_api.domain.models.Department;
import com.gategroup.mantix_api.infrastructure.entities.DepartmentEntity;

public class DepartmentMapper {
    public static DepartmentDTO toDto(Department department) {
        DepartmentDTO departmentDto = new DepartmentDTO();
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        departmentDto.setCode(department.getCode());
        departmentDto.setCountry(CountryMapper.toDto(department.getCountry()));
        return departmentDto;
    }

    public static Department toDomain(DepartmentEntity departmentEntity) {
        return new Department(
                departmentEntity.getId(),
                departmentEntity.getName(),
                departmentEntity.getCode(),
                CountryMapper.toDomain(departmentEntity.getCountry()));
    }

    public static DepartmentEntity toEntity(Department department) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(department.getId());
        departmentEntity.setName(department.getName());
        departmentEntity.setCode(department.getCode());
        departmentEntity.setCountry(CountryMapper.toEntity(department.getCountry()));
        return departmentEntity;
    }
}
