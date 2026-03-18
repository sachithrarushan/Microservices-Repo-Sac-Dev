package com.microservices.employee_service.service.impl;

import com.microservices.employee_service.dto.OrganizationDto;
import com.microservices.employee_service.service.FeignClientOrganizationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationServiceClient {

    private final FeignClientOrganizationService feignClientOrganizationService;

    @CircuitBreaker(name = "organizationCB", fallbackMethod = "organizationFallback")
    @Retry(name = "organizationServiceRetry")
    public OrganizationDto getOrganization(String organizationCode) {
        return feignClientOrganizationService.getOrganization(organizationCode);
    }

    public OrganizationDto organizationFallback(String organizationCode, Throwable ex) {
        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setOrganizationName("Organization Service Down");
        organizationDto.setOrganizationDescription("Service unavailable");
        organizationDto.setOrganizationCode("N/A");
        return organizationDto;
    }
}
