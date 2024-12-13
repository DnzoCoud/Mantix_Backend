package com.dnzocoud.mantix_api.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnzocoud.mantix_api.application.dto.Auth.AuthResponse;
import com.dnzocoud.mantix_api.application.dto.Auth.LoginRequest;
import com.dnzocoud.mantix_api.application.dto.response.ApiResponse;
import com.dnzocoud.mantix_api.application.usecases.auth.LoginUseCase;
import com.dnzocoud.mantix_api.infrastructure.adapters.BaseController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController extends BaseController {
    private final LoginUseCase loginUseCase;

    @Autowired
    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody LoginRequest loginRequest) {
        try {
            AuthResponse auth = loginUseCase.execute(loginRequest);
            return responseSuccess(auth);
        } catch (Exception e) {
            return responseError(e.getMessage());
        }
    }
}
