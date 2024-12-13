package com.dnzocoud.mantix_api.domain.models;

import com.dnzocoud.mantix_api.domain.util.StringUtilities;

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
    private Company company;
    private Subcompany subCompany;

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public void setEmail(String email) {
        if (!StringUtilities.isValidEmail(email)) {
            throw new IllegalArgumentException("Este correo no es valido");
        }
        this.email = email;
    }
}
