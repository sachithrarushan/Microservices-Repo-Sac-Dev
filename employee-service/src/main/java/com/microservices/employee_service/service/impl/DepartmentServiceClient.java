package com.microservices.employee_service.service.impl;

import com.microservices.employee_service.dto.DepartmentDto;
import com.microservices.employee_service.service.FeignClientDepartmentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceClient {

    private final FeignClientDepartmentService feignClientDepartmentService;

    @CircuitBreaker(name = "departmentCB", fallbackMethod = "departmentFallback")
    @Retry(name = "departmentServiceRetry")
    public DepartmentDto getDepartment(String departmentCode) {
        return feignClientDepartmentService.getDepartment(departmentCode);
    }

    public DepartmentDto departmentFallback(String departmentCode, Throwable ex) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("Department Service Down");
        departmentDto.setDepartmentCode("N/A");
        return departmentDto;
    }
}
