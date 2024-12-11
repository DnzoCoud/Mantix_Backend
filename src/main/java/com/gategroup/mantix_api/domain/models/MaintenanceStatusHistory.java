package com.gategroup.mantix_api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MaintenanceStatusHistory {
    private Long id;
    private Maintenance maintenance;
    private MaintenanceStatus fromStatus;
    private MaintenanceStatus toStatus;
    private User changedByUser;
}
