package com.gategroup.mantix_api.infrastructure.entities;

import java.time.LocalDate;
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
import lombok.Data;

@Data
@Entity
@Table(name = "maintenance_days ")
public class MaintenanceDayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name = "subcompany_id")
    private SubCompanyEntity subCompany;

    @OneToMany(mappedBy = Constants.MAPPED_BY_MAINTENANCE_DAY)
    private Set<MaintenanceEntity> maintenances = new HashSet<>();
}
