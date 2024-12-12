package com.gategroup.mantix_api.infrastructure.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gategroup.mantix_api.domain.models.Company;
import com.gategroup.mantix_api.domain.services.ICompanyService;
import com.gategroup.mantix_api.infrastructure.entities.CompanyEntity;
import com.gategroup.mantix_api.infrastructure.persistence.CompanyRepositoryJpa;
import com.gategroup.mantix_api.presentation.mappers.CompanyMapper;

@Service
public class CompanyServiceImpl implements ICompanyService {
    private final CompanyRepositoryJpa companyRepositoryJpa;

    @Autowired
    public CompanyServiceImpl(CompanyRepositoryJpa companyRepositoryJpa) {
        this.companyRepositoryJpa = companyRepositoryJpa;
    }

    @Override
    public Optional<Company> find(Long id) {
        Optional<CompanyEntity> companyEntity = companyRepositoryJpa.findById(id);
        return companyEntity.map(CompanyMapper::toDomain);
    }

    @Override
    public List<Company> findAll() {
        List<CompanyEntity> entities = companyRepositoryJpa.findAll();
        return entities.stream().map(CompanyMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Company store(Company company) {
        CompanyEntity companyEntity = companyRepositoryJpa.save(CompanyMapper.toEntity(company));
        return CompanyMapper.toDomain(companyEntity);
    }

    @Override
    public Company update(Company company) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean destroy(Long id) {
        // TODO Auto-generated method stub
        return false;
    }
}
