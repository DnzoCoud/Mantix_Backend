package com.dnzocoud.mantix_api.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dnzocoud.mantix_api.application.usecases.department.GetDepartmentById;
import com.dnzocoud.mantix_api.domain.services.IDepartmentService;

@Configuration
public class DepartmentUseCaseConfig {
    private final IDepartmentService departmentService;

    @Autowired
    public DepartmentUseCaseConfig(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Bean
    public GetDepartmentById getDepartmentById() {
        return new GetDepartmentById(departmentService);
    }
}
