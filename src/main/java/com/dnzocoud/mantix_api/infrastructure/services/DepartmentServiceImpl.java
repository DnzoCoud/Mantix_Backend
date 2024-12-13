package com.dnzocoud.mantix_api.infrastructure.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnzocoud.mantix_api.domain.models.Department;
import com.dnzocoud.mantix_api.domain.services.IDepartmentService;
import com.dnzocoud.mantix_api.infrastructure.entities.DepartmentEntity;
import com.dnzocoud.mantix_api.infrastructure.mappers.DepartmentEntityMapper;
import com.dnzocoud.mantix_api.infrastructure.persistence.DepartmentRepositoryJpa;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    private final DepartmentRepositoryJpa departmentRepositoryJpa;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepositoryJpa departmentRepositoryJpa) {
        this.departmentRepositoryJpa = departmentRepositoryJpa;
    }

    @Override
    public Optional<Department> find(Long id) {
        Optional<DepartmentEntity> entity = departmentRepositoryJpa.findById(id);
        return entity.map(DepartmentEntityMapper::toDomain);
    }

    @Override
    public List<Department> findAll() {
        List<DepartmentEntity> entities = departmentRepositoryJpa.findAll();
        return entities.stream().map(DepartmentEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Department store(Department domain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'store'");
    }

    @Override
    public Department update(Department domain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean destroy(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

}
