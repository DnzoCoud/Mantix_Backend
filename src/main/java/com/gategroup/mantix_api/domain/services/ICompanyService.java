package com.gategroup.mantix_api.domain.services;

import java.util.List;
import java.util.Optional;

import com.gategroup.mantix_api.domain.models.Company;

public interface ICompanyService {
    Optional<Company> find(Long id);

    List<Company> findAll();

    Company store(Company company);

    Company update(Company company);

    boolean destroy(Long id);
}
