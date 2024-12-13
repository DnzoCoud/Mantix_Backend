package com.dnzocoud.mantix_api.infrastructure.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import com.dnzocoud.mantix_api.domain.models.Permission;
import com.dnzocoud.mantix_api.infrastructure.entities.PermissionEntity;

public class PermissionEntityMapper {
    public static Set<Permission> muchToDomain(Set<PermissionEntity> permissionEntities) {
        return permissionEntities.stream().map(permission -> toDomain(permission)).collect(Collectors.toSet());
    }

    public static Permission toDomain(PermissionEntity permissionEntity) {
        return new Permission(permissionEntity.getId(), permissionEntity.getName(), permissionEntity.getIcon());
    }
}
