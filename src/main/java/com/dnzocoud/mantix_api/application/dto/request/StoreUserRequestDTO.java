package com.dnzocoud.mantix_api.application.dto.request;

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
    private Long roleId;
    private Long companyId;
    private Long subCompanyId;
}
