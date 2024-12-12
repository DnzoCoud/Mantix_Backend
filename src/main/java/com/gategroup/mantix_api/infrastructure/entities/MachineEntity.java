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
import lombok.Getter;

@Getter
@Entity
@Table(name = "machines")
public class MachineEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    private String serial;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationEntity location;

    @OneToMany(mappedBy = Constants.MAPPED_BY_MACHINE)
    private Set<MaintenanceEntity> maintenances = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "machine_status_id")
    private MachineStatusEntity machineStatus;
}
