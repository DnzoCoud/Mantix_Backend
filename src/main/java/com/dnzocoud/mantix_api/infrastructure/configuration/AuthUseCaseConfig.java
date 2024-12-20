package com.dnzocoud.mantix_api.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dnzocoud.mantix_api.application.usecases.auth.LoginUseCase;
import com.dnzocoud.mantix_api.domain.services.AuthenticacionService;
import com.dnzocoud.mantix_api.domain.services.ITokenService;

@Configuration
public class AuthUseCaseConfig {
    private final AuthenticacionService authenticacionService;
    private final ITokenService tokenProvider;

    @Autowired
    public AuthUseCaseConfig(AuthenticacionService authenticacionService, ITokenService tokenProvider) {
        this.authenticacionService = authenticacionService;
        this.tokenProvider = tokenProvider;
    }

    @Bean
    public LoginUseCase loginUseCase() {
        return new LoginUseCase(authenticacionService, tokenProvider);
    }
}
