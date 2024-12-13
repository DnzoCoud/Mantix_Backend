package com.dnzocoud.mantix_api.application.mappers;

import com.dnzocoud.mantix_api.application.dto.MaintenanceAttachmentDTO;
import com.dnzocoud.mantix_api.domain.models.MaintenanceAttachment;

public final class MaintenanceAttachmentMapper {
    public static MaintenanceAttachmentDTO toDto(MaintenanceAttachment maintenanceAttachment) {
        MaintenanceAttachmentDTO maintenanceAttachmentDto = new MaintenanceAttachmentDTO();
        maintenanceAttachmentDto.setId(maintenanceAttachment.getId());
        maintenanceAttachmentDto.setFilePath(maintenanceAttachment.getFilePath());
        maintenanceAttachmentDto.setFileType(maintenanceAttachment.getFileType());
        maintenanceAttachmentDto.setMaintenance(MaintenanceMapper.toDto(maintenanceAttachment.getMaintenance()));
        return maintenanceAttachmentDto;
    }
}
