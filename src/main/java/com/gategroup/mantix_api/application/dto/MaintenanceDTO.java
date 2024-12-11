package com.gategroup.mantix_api.application.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MaintenanceDTO {
    private Long id;
    private String uniqueNumber;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
    private String damageCauses;
    private String recommendations;
    private String observations;
    private MachineDTO machine;
    private MaintenanceStatusDTO maintenanceStatus;
    private MaintenanceDayDTO maintenanceDay;
    private MaintenanceExecutionTypeDTO executionType;
    private CompanyDTO company;
    private SubcompanyDTO subCompany;
}
