package com.gategroup.mantix_api.presentation.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import com.gategroup.mantix_api.application.dto.RoleDTO;
import com.gategroup.mantix_api.domain.models.Role;
import com.gategroup.mantix_api.infrastructure.entities.RoleEntity;

public class RoleMapper {
    public static RoleDTO toDto(Role role) {
        RoleDTO roleDto = new RoleDTO();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        roleDto.setIcon(role.getIcon());
        roleDto.setPermissions(role.getPermissions()
                .stream()
                .map(permission -> PermissionMapper.toDto(permission))
                .collect(Collectors.toSet()));
        return roleDto;
    }

    public static Set<Role> muchToDomain(Set<RoleEntity> roleEntities) {
        return roleEntities.stream().map(role -> toDomain(role)).collect(Collectors.toSet());
    }

    public static Role toDomain(RoleEntity roleEntity) {
        return new Role(roleEntity.getId(), roleEntity.getName(), roleEntity.getIcon(), roleEntity.getPermissions()
                .stream().map(permission -> PermissionMapper.toDomain(permission)).collect(Collectors.toSet()));
    }
}
