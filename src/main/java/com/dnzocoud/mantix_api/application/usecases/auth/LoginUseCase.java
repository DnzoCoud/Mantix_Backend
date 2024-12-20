package com.dnzocoud.mantix_api.application.usecases.auth;

import com.dnzocoud.mantix_api.application.dto.Auth.AuthResponse;
import com.dnzocoud.mantix_api.application.dto.Auth.LoginRequest;
import com.dnzocoud.mantix_api.application.mappers.UserMapper;
import com.dnzocoud.mantix_api.domain.models.User;
import com.dnzocoud.mantix_api.domain.services.AuthenticacionService;
import com.dnzocoud.mantix_api.domain.services.ITokenService;
import com.dnzocoud.mantix_api.infrastructure.exceptions.InvalidCredentialsException;

public class LoginUseCase {

    private final AuthenticacionService authenticacionService;
    private final ITokenService jwtProvider;

    public LoginUseCase(AuthenticacionService authService, ITokenService jwtProvider) {
        this.authenticacionService = authService;
        this.jwtProvider = jwtProvider;
    }

    public AuthResponse execute(LoginRequest loginRequest) {
        if (loginRequest.getEmail() == null || loginRequest.getEmail().isEmpty()) {
            throw new InvalidCredentialsException("El email es obligatorio.");
        }
        User user = authenticacionService.login(loginRequest.getEmail(), loginRequest.getPassword());
        String token = jwtProvider.generateToken(user);
        System.out.println("token: " + token);
        return new AuthResponse(token, UserMapper.toDto(user));
    }
}
