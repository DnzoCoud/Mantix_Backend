package com.gategroup.mantix_api.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "maintenance_activities")
public class MaintenanceActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean completed;
    private String observations;
    private String usedPares;

    @ManyToOne
    @JoinColumn(name = "maintenance_id")
    private MaintenanceEntity maintenance;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private UserEntity technician;

    @OneToMany(mappedBy = "maintenanceActivity")
    private Set<ActivityAttachmentEntity> activityAttachments = new HashSet<>();
}
