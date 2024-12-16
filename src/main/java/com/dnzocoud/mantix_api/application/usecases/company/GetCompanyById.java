package com.dnzocoud.mantix_api.application.usecases.company;

import com.dnzocoud.mantix_api.domain.exceptions.ResourceNotFoundException;
import com.dnzocoud.mantix_api.domain.models.Company;
import com.dnzocoud.mantix_api.domain.services.ICompanyService;

public class GetCompanyById {
    private final ICompanyService companyService;

    public GetCompanyById(ICompanyService companyService) {
        this.companyService = companyService;
    }

    public Company execute(Long id) {
        return companyService.find(id).orElseThrow(() -> new ResourceNotFoundException("Company no existe"));
    }
}
