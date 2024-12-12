package com.gategroup.mantix_api.infrastructure.entities;

import java.util.HashSet;
import java.util.Set;

import com.gategroup.mantix_api.domain.abstracts.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "departments")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @OneToMany(mappedBy = Constants.MAPPED_BY_DEPARTMENT)
    private Set<CityEntity> cities = new HashSet<>();

    @OneToMany(mappedBy = Constants.MAPPED_BY_DEPARTMENT)
    private Set<CompanyEntity> companies = new HashSet<>();

    @OneToMany(mappedBy = Constants.MAPPED_BY_DEPARTMENT)
    private Set<SubCompanyEntity> subCompanies = new HashSet<>();

}
