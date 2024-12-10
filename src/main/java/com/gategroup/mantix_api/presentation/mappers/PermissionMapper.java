package com.gategroup.mantix_api.presentation.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import com.gategroup.mantix_api.application.dto.PermissionDTO;
import com.gategroup.mantix_api.domain.models.Permission;
import com.gategroup.mantix_api.infrastructure.entities.PermissionEntity;

public class PermissionMapper {
    public static PermissionDTO toDto(Permission permission) {
        return new PermissionDTO(permission.getId(), permission.getName(), permission.getIcon());
    }

    public static Set<Permission> muchToDomain(Set<PermissionEntity> permissionEntities) {
        return permissionEntities.stream().map(permission -> toDomain(permission)).collect(Collectors.toSet());
    }

    public static Permission toDomain(PermissionEntity permissionEntity) {
        return new Permission(permissionEntity.getId(), permissionEntity.getName(), permissionEntity.getIcon());
    }
}
