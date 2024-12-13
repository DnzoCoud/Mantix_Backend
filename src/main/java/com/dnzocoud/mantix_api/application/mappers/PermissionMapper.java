package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.PermissionDTO;
import com.dnzocoud.mantix_api.domain.models.Permission;

public final class PermissionMapper {
    public static PermissionDTO toDto(Permission permission) {
        return new PermissionDTO(permission.getId(), permission.getName(), permission.getIcon());
    }
}
