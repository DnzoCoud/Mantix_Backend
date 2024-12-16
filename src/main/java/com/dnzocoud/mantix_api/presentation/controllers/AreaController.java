package com.dnzocoud.mantix_api.presentation.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnzocoud.mantix_api.application.dto.AreaDTO;
import com.dnzocoud.mantix_api.application.dto.request.ImportExcelRequestDTO;
import com.dnzocoud.mantix_api.application.dto.response.ApiResponse;
import com.dnzocoud.mantix_api.infrastructure.adapters.BaseController;

@RestController
@RequestMapping("api/v1/areas")
public class AreaController extends BaseController {

    @PostMapping("/import/excel")
    public ResponseEntity<ApiResponse<List<AreaDTO>>> importAreasByExcel(
            @RequestBody ImportExcelRequestDTO importExcelRequestDTO) {
        try {
            return responseSuccess(new ArrayList<>());
        } catch (Exception e) {
            return responseError(e.getMessage());
        }
    }

}
