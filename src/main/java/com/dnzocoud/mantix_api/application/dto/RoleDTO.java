package com.dnzocoud.mantix_api.application.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleDTO {
    private Long id;
    private String name;
    private String icon;
    private Set<PermissionDTO> permissions;
    private CompanyDTO company;
    private SubcompanyDTO subCompany;
}
