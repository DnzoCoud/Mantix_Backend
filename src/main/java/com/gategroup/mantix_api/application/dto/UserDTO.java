package com.gategroup.mantix_api.application.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String fullName;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private RoleDTO role;
    private CompanyDTO company;
    private SubcompanyDTO subCompany;
}
