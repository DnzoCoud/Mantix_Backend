package com.dnzocoud.mantix_api.application.mappers;

import java.util.stream.Collectors;

import com.dnzocoud.mantix_api.application.dto.RoleDTO;
import com.dnzocoud.mantix_api.domain.models.Role;

public final class RoleMapper {
    public static RoleDTO toDto(Role role) {
        RoleDTO roleDto = new RoleDTO();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        roleDto.setIcon(role.getIcon());
        roleDto.setPermissions(role.getPermissions()
                .stream()
                .map(permission -> PermissionMapper.toDto(permission))
                .collect(Collectors.toSet()));
        roleDto.setCompany(CompanyMapper.toDto(role.getCompany()));
        roleDto.setSubCompany(SubcompanyMapper.toDto(role.getSubCompany()));
        return roleDto;
    }
}
