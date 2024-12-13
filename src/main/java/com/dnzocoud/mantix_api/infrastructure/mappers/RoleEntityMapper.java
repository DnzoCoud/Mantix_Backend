package com.dnzocoud.mantix_api.infrastructure.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import com.dnzocoud.mantix_api.domain.models.Role;
import com.dnzocoud.mantix_api.infrastructure.entities.RoleEntity;

public final class RoleEntityMapper {

    public static Set<Role> muchToDomain(Set<RoleEntity> roleEntities) {
        return roleEntities.stream().map(RoleEntityMapper::toDomain).collect(Collectors.toSet());
    }

    public static Role toDomain(RoleEntity roleEntity) {
        return new Role(roleEntity.getId(),
                roleEntity.getName(),
                roleEntity.getIcon(),
                roleEntity.getPermissions()
                        .stream()
                        .map(PermissionEntityMapper::toDomain)
                        .collect(Collectors.toSet()),
                CompanyEntityMapper.toDomain(roleEntity.getCompany()),
                SubcompanyEntityMapper.toDomain(roleEntity.getSubCompany()));
    }

    public static RoleEntity toEntity(Role role) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(role.getId());
        roleEntity.setName(role.getName());
        roleEntity.setIcon(role.getIcon());
        roleEntity.setCompany(CompanyEntityMapper.toEntity(role.getCompany()));
        roleEntity.setSubCompany(SubcompanyEntityMapper.toEntity(role.getSubCompany()));
        roleEntity.setPermissions(
                role.getPermissions()
                        .stream()
                        .map(PermissionEntityMapper::toEntity)
                        .collect(Collectors.toSet()));
        return roleEntity;
    }
}
