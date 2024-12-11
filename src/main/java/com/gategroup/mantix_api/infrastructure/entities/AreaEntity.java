package com.gategroup.mantix_api.infrastructure.entities;

import java.util.Set;

import com.gategroup.mantix_api.domain.abstracts.Constants;

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
@Table(name = "areas")
public class AreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name = "subcompany_id")
    private SubCompanyEntity subCompany;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private UserEntity director;

    @OneToMany(mappedBy = Constants.MAPPED_BY_AREA)
    private Set<LocationEntity> locations;
}
