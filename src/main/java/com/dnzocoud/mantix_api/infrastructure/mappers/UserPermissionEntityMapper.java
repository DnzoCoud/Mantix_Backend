package com.dnzocoud.mantix_api.infrastructure.mappers;

import com.dnzocoud.mantix_api.domain.models.UserPermission;
import com.dnzocoud.mantix_api.infrastructure.entities.UserPermissionEntity;

public final class UserPermissionEntityMapper {

    public static UserPermission toDomain(UserPermissionEntity userPermissionEntity) {
        return new UserPermission(
                userPermissionEntity.getId(),
                UserEntityMapper.toDomain(userPermissionEntity.getUser()),
                PermissionEntityMapper.toDomain(userPermissionEntity.getPermission()),
                userPermissionEntity.isAllowed());
    }

    public static UserPermissionEntity toEntity(UserPermission userPermission) {
        UserPermissionEntity userPermissionEntity = new UserPermissionEntity();
        userPermissionEntity.setId(userPermission.getId());
        userPermissionEntity.setUser(UserEntityMapper.toEntity(userPermission.getUser()));
        userPermissionEntity.setPermission(PermissionEntityMapper.toEntity(userPermission.getPermission()));
        userPermissionEntity.setAllowed(userPermission.isAllowed());
        return userPermissionEntity;
    }
}