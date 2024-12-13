package com.dnzocoud.mantix_api.domain.models;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Maintenance {
    private Long id;
    private String uniqueNumber;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
    private String damageCauses;
    private String recommendations;
    private String observations;
    private Machine machine;
    private MaintenanceStatus maintenanceStatus;
    private MaintenanceDay maintenanceDay;
    private MaintenanceExecutionType executionType;
    private Company company;
    private Subcompany subCompany;
}
