package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.UserPermissionDTO;
import com.gategroup.mantix_api.domain.models.UserPermission;

public class UserPermissionMapper {
    public static UserPermissionDTO toDto(UserPermission userPermission) {
        UserPermissionDTO userPermissionDto = new UserPermissionDTO();
        userPermissionDto.setId(userPermission.getId());
        userPermissionDto.setUser(UserMapper.toDto(userPermission.getUser()));
        userPermissionDto.setPermission(PermissionMapper.toDto(userPermission.getPermission()));
        userPermissionDto.setAllowed(userPermission.isAllowed());
        return userPermissionDto;
    }
}