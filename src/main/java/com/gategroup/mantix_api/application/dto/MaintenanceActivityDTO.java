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
public class MaintenanceActivityDTO {
    private Long id;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean completed;
    private String observation;
    private String usedSpares;
    private MaintenanceDTO maintenance;
    private UserDTO technician;
}
