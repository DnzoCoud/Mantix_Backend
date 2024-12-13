package com.dnzocoud.mantix_api.infrastructure.entities;

import java.util.HashSet;
import java.util.Set;

import com.dnzocoud.mantix_api.domain.abstracts.Constants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "maintenance_status")
public class MaintenanceStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = Constants.MAPPED_BY_MAINTENANCE_STATUS)
    private Set<MaintenanceEntity> maintenances = new HashSet<>();

    @OneToMany(mappedBy = "fromStatus")
    private Set<MaintenanceStatusHistoryEntity> fromMaintenanceStatusHistory = new HashSet<>();

    @OneToMany(mappedBy = "toStatus")
    private Set<MaintenanceStatusHistoryEntity> toMaintenanceStatusHistory = new HashSet<>();
}
