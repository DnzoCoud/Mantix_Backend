package com.gategroup.mantix_api.application.dto.request;

public record StoreCompanyRequestDTO(
                String name,
                String sector,
                String status,
                String ubication,
                String configuration,
                Long countryId,
                Long departmentId,
                Long cityId) {

}
