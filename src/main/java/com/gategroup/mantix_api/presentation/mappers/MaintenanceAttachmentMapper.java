package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.MaintenanceAttachmentDTO;
import com.gategroup.mantix_api.domain.models.MaintenanceAttachment;

public class MaintenanceAttachmentMapper {
    public static MaintenanceAttachmentDTO toDto(MaintenanceAttachment maintenanceAttachment) {
        MaintenanceAttachmentDTO maintenanceAttachmentDto = new MaintenanceAttachmentDTO();
        maintenanceAttachmentDto.setId(maintenanceAttachment.getId());
        maintenanceAttachmentDto.setFilePath(maintenanceAttachment.getFilePath());
        maintenanceAttachmentDto.setFileType(maintenanceAttachment.getFileType());
        maintenanceAttachmentDto.setMaintenance(MaintenanceMapper.toDto(maintenanceAttachment.getMaintenance()));
        return maintenanceAttachmentDto;
    }
}
