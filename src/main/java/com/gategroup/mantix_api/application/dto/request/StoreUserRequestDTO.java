package com.gategroup.mantix_api.application.dto.request;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreUserRequestDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int role;
    private Set<Integer> permissions;
}
