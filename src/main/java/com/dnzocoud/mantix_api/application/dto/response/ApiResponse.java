package com.dnzocoud.mantix_api.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public static <T> ApiResponse<T> responseSuccess(T data) {
        return new ApiResponse<T>(true, "Operación Exitosa.", data);
    }

    public static <T> ApiResponse<T> responseSuccess(String message, T data) {
        return new ApiResponse<T>(true, message, data);
    }

    public static <T> ApiResponse<T> responseError(String message){
        return new ApiResponse<T>(false, message, null);
    }
}
