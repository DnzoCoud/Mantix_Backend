package com.dnzocoud.mantix_api.infrastructure.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnzocoud.mantix_api.domain.models.SubCompany;
import com.dnzocoud.mantix_api.domain.services.ISubCompanyService;
import com.dnzocoud.mantix_api.infrastructure.entities.SubCompanyEntity;
import com.dnzocoud.mantix_api.infrastructure.mappers.SubcompanyEntityMapper;
import com.dnzocoud.mantix_api.infrastructure.persistence.SubCompanyRepositoryJpa;

@Service
public class SubCompanyServiceImpl implements ISubCompanyService {
    private final SubCompanyRepositoryJpa subCompanyRepositoryJpa;

    @Autowired
    public SubCompanyServiceImpl(SubCompanyRepositoryJpa subCompanyRepositoryJpa) {
        this.subCompanyRepositoryJpa = subCompanyRepositoryJpa;
    }

    @Override
    public Optional<SubCompany> find(Long id) {
        Optional<SubCompanyEntity> entity = subCompanyRepositoryJpa.findById(id);
        return entity.map(SubcompanyEntityMapper::toDomain);
    }

    @Override
    public List<SubCompany> findAll() {
        List<SubCompanyEntity> entities = subCompanyRepositoryJpa.findAll();
        return entities.stream().map(SubcompanyEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public SubCompany store(SubCompany domain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'store'");
    }

    @Override
    public SubCompany update(SubCompany domain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean destroy(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

}
