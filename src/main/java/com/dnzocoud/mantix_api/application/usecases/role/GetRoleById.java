package com.dnzocoud.mantix_api.application.usecases.role;

import com.dnzocoud.mantix_api.domain.exceptions.ResourceNotFoundException;
import com.dnzocoud.mantix_api.domain.models.Role;
import com.dnzocoud.mantix_api.domain.services.IRoleService;

public class GetRoleById {
    private final IRoleService roleService;

    public GetRoleById(IRoleService roleService) {
        this.roleService = roleService;
    }

    public Role execute(Long id) {
        return roleService.find(id).orElseThrow(() -> new ResourceNotFoundException("El rol no existe."));
    }
}
