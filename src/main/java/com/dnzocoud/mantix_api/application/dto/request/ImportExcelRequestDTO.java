package com.dnzocoud.mantix_api.application.dto.request;

public record ImportExcelRequestDTO(
        String excelBase64,
        Long companyId,
        Long subCompanyId) {

}
