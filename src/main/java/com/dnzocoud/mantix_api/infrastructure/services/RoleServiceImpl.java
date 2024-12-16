package com.dnzocoud.mantix_api.infrastructure.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnzocoud.mantix_api.domain.models.Role;
import com.dnzocoud.mantix_api.domain.services.IRoleService;
import com.dnzocoud.mantix_api.infrastructure.entities.RoleEntity;
import com.dnzocoud.mantix_api.infrastructure.mappers.RoleEntityMapper;
import com.dnzocoud.mantix_api.infrastructure.persistence.RoleRepositoryJpa;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    private final RoleRepositoryJpa roleRepositoryJpa;

    @Autowired
    public RoleServiceImpl(RoleRepositoryJpa roleRepositoryJpa) {
        this.roleRepositoryJpa = roleRepositoryJpa;
    }

    @Override
    public Optional<Role> find(Long id) {
        Optional<RoleEntity> roleEntity = roleRepositoryJpa.findById(id);
        return roleEntity.map(RoleEntityMapper::toDomain);
    }

    @Override
    public List<Role> findAll() {
        List<RoleEntity> entities = roleRepositoryJpa.findAll();
        return entities.stream().map(RoleEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Role store(Role domain) {
        RoleEntity entity = roleRepositoryJpa.save(RoleEntityMapper.toEntity(domain));
        return RoleEntityMapper.toDomain(entity);
    }

    @Override
    public Role update(Role domain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean destroy(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

}
