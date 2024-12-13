package com.dnzocoud.mantix_api.application.dto.Auth;

import com.dnzocoud.mantix_api.application.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private String token;
    private UserDTO user;
}
