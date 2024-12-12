package com.gategroup.mantix_api.application.usecases.company;

import java.util.List;
import java.util.stream.Collectors;

import com.gategroup.mantix_api.application.dto.CompanyDTO;
import com.gategroup.mantix_api.domain.services.ICompanyService;
import com.gategroup.mantix_api.presentation.mappers.CompanyMapper;

public class FindAllCompanies {
    private final ICompanyService companyService;

    public FindAllCompanies(ICompanyService companyService) {
        this.companyService = companyService;
    }

    public List<CompanyDTO> execute() {
        return companyService.findAll().stream().map(CompanyMapper::toDto).collect(Collectors.toList());
    }
}
