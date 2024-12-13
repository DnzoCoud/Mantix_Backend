package com.dnzocoud.mantix_api.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnzocoud.mantix_api.application.dto.CompanyDTO;
import com.dnzocoud.mantix_api.application.dto.request.StoreCompanyRequestDTO;
import com.dnzocoud.mantix_api.application.dto.response.ApiResponse;
import com.dnzocoud.mantix_api.application.usecases.company.FindAllCompanies;
import com.dnzocoud.mantix_api.application.usecases.company.StoreCompany;
import com.dnzocoud.mantix_api.infrastructure.adapters.BaseController;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController extends BaseController {
    private final StoreCompany storeCompany;
    private final FindAllCompanies findAllCompanies;

    @Autowired
    public CompanyController(StoreCompany storeCompany, FindAllCompanies findAllCompanies) {
        this.storeCompany = storeCompany;
        this.findAllCompanies = findAllCompanies;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CompanyDTO>>> all() {
        try {
            return responseSuccess("Listado de empreas", findAllCompanies.execute());
        } catch (Exception e) {
            return responseError(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CompanyDTO>> store(@RequestBody StoreCompanyRequestDTO storeCompanyRequest) {
        try {
            return responseSuccess("Creacion exitosa.", storeCompany.execute(storeCompanyRequest));
        } catch (Exception e) {
            return responseError(e.getMessage());
        }
    }
}
