package com.dnzocoud.mantix_api.application.usecases.company;

import java.util.List;
import java.util.stream.Collectors;

import com.dnzocoud.mantix_api.application.dto.CompanyDTO;
import com.dnzocoud.mantix_api.application.mappers.CompanyMapper;
import com.dnzocoud.mantix_api.domain.services.ICompanyService;

public class FindAllCompanies {
    private final ICompanyService companyService;

    public FindAllCompanies(ICompanyService companyService) {
        this.companyService = companyService;
    }

    public List<CompanyDTO> execute() {
        return companyService.findAll().stream().map(CompanyMapper::toDto).collect(Collectors.toList());
    }
}
