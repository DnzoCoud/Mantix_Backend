package com.gategroup.mantix_api.presentation.mappers;

import com.gategroup.mantix_api.application.dto.ActivityAttachmentDTO;
import com.gategroup.mantix_api.domain.models.ActivityAttachment;

public class ActivityAttachmentMapper {
    public static ActivityAttachmentDTO toDto(ActivityAttachment activityAttachment) {
        ActivityAttachmentDTO activityAttachmentDto = new ActivityAttachmentDTO();
        activityAttachmentDto.setId(activityAttachment.getId());
        activityAttachmentDto.setFilePath(activityAttachment.getFilePath());
        activityAttachmentDto.setFileType(activityAttachment.getFileType());
        activityAttachmentDto
                .setMaintenanceActivity(MaintenanceActivityMapper.toDto(activityAttachment.getMaintenanceActivity()));
        return activityAttachmentDto;
    }
}
