package com.dnzocoud.mantix_api.infrastructure.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnzocoud.mantix_api.domain.models.Country;
import com.dnzocoud.mantix_api.domain.services.ICountryService;
import com.dnzocoud.mantix_api.infrastructure.entities.CountryEntity;
import com.dnzocoud.mantix_api.infrastructure.mappers.CountryEntityMapper;
import com.dnzocoud.mantix_api.infrastructure.persistence.CountryRepositoryJpa;

@Service
public class CountryServiceImpl implements ICountryService {
    private final CountryRepositoryJpa countryRepositoryJpa;

    @Autowired
    public CountryServiceImpl(CountryRepositoryJpa countryRepositoryJpa) {
        this.countryRepositoryJpa = countryRepositoryJpa;
    } 

    @Override
    public Optional<Country> find(Long id) {
        Optional<CountryEntity> coutryEntity = countryRepositoryJpa.findById(id);
        return coutryEntity.map(CountryEntityMapper::toDomain);
    }

    @Override
    public List<Country> findAll() {
        List<CountryEntity> countries = countryRepositoryJpa.findAll();
        return countries.stream().map(CountryEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Country store(Country country) {
        return null;
    }

    @Override
    public Country update(Country country) {
        return null;
    }

    @Override
    public boolean destroy(Long id) {
        return false;
    }
}
