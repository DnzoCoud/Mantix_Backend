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
public class MaintenanceActivity {
    private Long id;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean completed;
    private String observation;
    private String usedSpares;
    private Maintenance maintenance;
    private User technician;
}
