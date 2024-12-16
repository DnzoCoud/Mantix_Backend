package com.dnzocoud.mantix_api.domain.models;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role {
    private Long id;
    private String name;
    private String icon;
    private Set<Permission> permissions;
    private Company company;
    private SubCompany subCompany;
}
