package com.gategroup.mantix_api.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "maintenance_status_history")
public class MaintenanceStatusHistoryEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "maintenance_id")
    private MaintenanceEntity maintenance;
    @ManyToOne
    @JoinColumn(name = "from_status_id")
    private MaintenanceStatusEntity fromStatus;
    @ManyToOne
    @JoinColumn(name = "to_status_id")
    private MaintenanceStatusEntity toStatus;
    @ManyToOne
    @JoinColumn(name = "changed_by_user_id")
    private UserEntity changedByUser;
}
