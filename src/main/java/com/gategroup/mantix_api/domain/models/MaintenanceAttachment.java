package com.gategroup.mantix_api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MaintenanceAttachment {
    private Long id;
    private String filePath;
    private String fileType;
    private Maintenance maintenance;
}
