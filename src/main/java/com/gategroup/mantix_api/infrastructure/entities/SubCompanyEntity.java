package com.gategroup.mantix_api.infrastructure.entities;

import java.util.HashSet;
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
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;

@Getter
@Entity
@Table(name = "sub_companies", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
public class SubCompanyEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sector;
    private String ubication;
    private String status;
    private String configuration;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

    @OneToMany(mappedBy = Constants.MAPPED_BY_SUB_COMPANY)
    private Set<RoleEntity> roles = new HashSet<>();

    @OneToMany(mappedBy = Constants.MAPPED_BY_SUB_COMPANY)
    private Set<UserEntity> users = new HashSet<>();

    @OneToMany(mappedBy = Constants.MAPPED_BY_SUB_COMPANY)
    private Set<AreaEntity> areas = new HashSet<>();

    @OneToMany(mappedBy = Constants.MAPPED_BY_SUB_COMPANY)
    private Set<MaintenanceDayEntity> maintenanceDays = new HashSet<>();

    @OneToMany(mappedBy = Constants.MAPPED_BY_SUB_COMPANY)
    private Set<MaintenanceEntity> maintenances = new HashSet<>();
}
