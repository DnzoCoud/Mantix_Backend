package com.gategroup.mantix_api.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.gategroup.mantix_api.domain.abstracts.Constants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "maintenances")
public class MaintenanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uniqueNumber;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
    private String damageCause;
    private String recommendations;
    private String observations;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private MachineEntity machine;

    @ManyToOne
    @JoinColumn(name = "maintenance_status_id")
    private MaintenanceStatusEntity maintenanceStatus;

    @ManyToOne
    @JoinColumn(name = "maintenance_day_id")
    private MaintenanceDayEntity maintenanceDay;

    @ManyToOne
    @JoinColumn(name = "maintenance_execution_type_id")
    private MaintenanceExecutionTypeEntity maintenanceExecutionType;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name = "subcompany_id")
    private SubCompanyEntity subCompany;

    @OneToMany(mappedBy = Constants.MAPPED_BY_MAINTENANCE)
    private Set<MaintenanceAttachmentEntity> maintenanceAttachments = new HashSet<>();

    @OneToMany(mappedBy = Constants.MAPPED_BY_MAINTENANCE)
    private Set<MaintenanceStatusHistoryEntity> maintenanceStatusHistory = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "technician_maintenance", joinColumns = @JoinColumn(name = "maintenance_id"), inverseJoinColumns = @JoinColumn(name = "technician_id"))
    private Set<UserEntity> technicians = new HashSet<>();
}
