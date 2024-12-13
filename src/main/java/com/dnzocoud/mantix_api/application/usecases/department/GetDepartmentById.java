package com.dnzocoud.mantix_api.application.usecases.department;

import com.dnzocoud.mantix_api.domain.exceptions.ResourceNotFoundException;
import com.dnzocoud.mantix_api.domain.models.Department;
import com.dnzocoud.mantix_api.domain.services.IDepartmentService;

public class GetDepartmentById {
    private final IDepartmentService departmentService;

    public GetDepartmentById(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public Department execute(Long id) {
        return departmentService.find(id).orElseThrow(() -> new ResourceNotFoundException("Departamento no existe"));
    }
}
