package com.dnzocoud.mantix_api.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnzocoud.mantix_api.infrastructure.entities.PermissionEntity;

public interface PermissionRepositoryJpa extends JpaRepository<PermissionEntity, Long> {

}
