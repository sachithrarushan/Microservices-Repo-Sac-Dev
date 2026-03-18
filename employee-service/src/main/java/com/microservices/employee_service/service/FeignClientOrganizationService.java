package com.microservices.employee_service.service;

import com.microservices.employee_service.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface FeignClientOrganizationService {

    @GetMapping("/api/v1/organization/getOrganizationForFeign/{code}")
    OrganizationDto getOrganization(@PathVariable("code") String code);
}
