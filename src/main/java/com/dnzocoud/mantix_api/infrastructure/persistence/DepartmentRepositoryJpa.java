package com.dnzocoud.mantix_api.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnzocoud.mantix_api.infrastructure.entities.DepartmentEntity;

@Repository
public interface DepartmentRepositoryJpa extends JpaRepository<DepartmentEntity, Long> {

}
