package com.dnzocoud.mantix_api.infrastructure.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnzocoud.mantix_api.domain.models.City;
import com.dnzocoud.mantix_api.domain.services.ICityService;
import com.dnzocoud.mantix_api.infrastructure.entities.CityEntity;
import com.dnzocoud.mantix_api.infrastructure.mappers.CityEntityMapper;
import com.dnzocoud.mantix_api.infrastructure.persistence.CityRepositoryJpa;

@Service
public class CityServiceImpl implements ICityService {
    private final CityRepositoryJpa cityRepositoryJpa;

    @Autowired
    public CityServiceImpl(CityRepositoryJpa cityRepositoryJpa) {
        this.cityRepositoryJpa = cityRepositoryJpa;
    }

    @Override
    public boolean destroy(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

    @Override
    public City store(City domain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'store'");
    }

    @Override
    public City update(City domain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<City> find(Long id) {
        Optional<CityEntity> cityEntity = cityRepositoryJpa.findById(id);
        return cityEntity.map(CityEntityMapper::toDomain);
    }

    @Override
    public List<City> findAll() {
        List<CityEntity> entities = cityRepositoryJpa.findAll();
        return entities.stream().map(CityEntityMapper::toDomain).collect(Collectors.toList());
    }

}
