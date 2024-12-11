package com.gategroup.mantix_api.domain.models;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private Set<Permission> permissions;
    private Company company;
    private Subcompany subCompany;
}
