package com.gategroup.mantix_api.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gategroup.mantix_api.infrastructure.entities.CountryEntity;

@Repository
public interface CountryRepositoryJpa extends JpaRepository<CountryEntity, Long> {

}
