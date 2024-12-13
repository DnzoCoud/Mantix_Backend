package com.dnzocoud.mantix_api.infrastructure.adapters;

import org.springframework.http.ResponseEntity;

import com.dnzocoud.mantix_api.application.dto.response.ApiResponse;

public abstract class BaseController {

    protected <T> ResponseEntity<ApiResponse<T>> responseSuccess(T data) {
        return ResponseEntity.ok(ApiResponse.responseSuccess(data));
    }

    protected <T> ResponseEntity<ApiResponse<T>> responseSuccess(String message, T data) {
        return ResponseEntity.ok(ApiResponse.responseSuccess(message, data));
    }

    protected <T> ResponseEntity<ApiResponse<T>> responseError(String message, int statusCode) {
        return ResponseEntity.status(statusCode).body(ApiResponse.responseError(message));
    }

    protected <T> ResponseEntity<ApiResponse<T>> responseError(String message) {
        return responseError(message, 400);
    }

}
