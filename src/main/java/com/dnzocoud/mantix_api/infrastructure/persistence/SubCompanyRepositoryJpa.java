package com.dnzocoud.mantix_api.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnzocoud.mantix_api.infrastructure.entities.SubCompanyEntity;

public interface SubCompanyRepositoryJpa extends JpaRepository<SubCompanyEntity, Long> {

}
