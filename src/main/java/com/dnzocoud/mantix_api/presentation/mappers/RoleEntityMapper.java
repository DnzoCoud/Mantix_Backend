package com.dnzocoud.mantix_api.presentation.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import com.dnzocoud.mantix_api.domain.models.Role;
import com.dnzocoud.mantix_api.infrastructure.entities.RoleEntity;

public class RoleEntityMapper {
    public static Set<Role> muchToDomain(Set<RoleEntity> roleEntities) {
        return roleEntities.stream().map(role -> toDomain(role)).collect(Collectors.toSet());
    }

    public static Role toDomain(RoleEntity roleEntity) {
        return new Role(roleEntity.getId(),
                roleEntity.getName(),
                roleEntity.getIcon(),
                roleEntity.getPermissions()
                        .stream()
                        .map(permission -> PermissionEntityMapper.toDomain(permission))
                        .collect(Collectors.toSet()),
                null, null);
    }
}
