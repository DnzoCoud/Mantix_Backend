package com.dnzocoud.mantix_api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MaintenanceAttachmentDTO {
    private Long id;
    private String filePath;
    private String fileType;
    private MaintenanceDTO maintenance;
}
