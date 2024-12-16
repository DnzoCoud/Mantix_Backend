package com.dnzocoud.mantix_api.application.usecases.subCompany;

import com.dnzocoud.mantix_api.domain.exceptions.ResourceNotFoundException;
import com.dnzocoud.mantix_api.domain.models.SubCompany;
import com.dnzocoud.mantix_api.domain.services.ISubCompanyService;

public class GetSubCompanyById {
    private final ISubCompanyService subCompanyService;

    public GetSubCompanyById(ISubCompanyService subCompanyService) {
        this.subCompanyService = subCompanyService;
    }

    public SubCompany execute(Long id) {
        return subCompanyService.find(id).orElseThrow(() -> new ResourceNotFoundException("Sub Company no encontrada"));
    }
}
