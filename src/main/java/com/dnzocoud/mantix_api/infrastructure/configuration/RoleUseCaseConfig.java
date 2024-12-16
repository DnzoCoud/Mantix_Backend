package com.dnzocoud.mantix_api.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dnzocoud.mantix_api.application.usecases.role.GetRoleById;
import com.dnzocoud.mantix_api.domain.services.IRoleService;

@Configuration
public class RoleUseCaseConfig {
    private final IRoleService roleService;

    @Autowired
    public RoleUseCaseConfig(IRoleService roleService) {
        this.roleService = roleService;
    }

    @Bean
    public GetRoleById getRoleById() {
        return new GetRoleById(roleService);
    }
}
