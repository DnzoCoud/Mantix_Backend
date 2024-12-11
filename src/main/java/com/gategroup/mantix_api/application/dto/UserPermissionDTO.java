package com.gategroup.mantix_api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserPermissionDTO {
    private Long id;
    private UserDTO user;
    private PermissionDTO permission;
    private boolean allowed;
}
