package com.dnzocoud.mantix_api.infrastructure.mappers;

import com.dnzocoud.mantix_api.domain.models.Department;
import com.dnzocoud.mantix_api.infrastructure.entities.DepartmentEntity;

public class DepartmentEntityMapper {

    public static Department toDomain(DepartmentEntity departmentEntity) {
        return new Department(
                departmentEntity.getId(),
                departmentEntity.getName(),
                departmentEntity.getCode(),
                CountryEntityMapper.toDomain(departmentEntity.getCountry()));
    }

    public static DepartmentEntity toEntity(Department department) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(department.getId());
        departmentEntity.setName(department.getName());
        departmentEntity.setCode(department.getCode());
        departmentEntity.setCountry(CountryEntityMapper.toEntity(department.getCountry()));
        return departmentEntity;
    }
}
