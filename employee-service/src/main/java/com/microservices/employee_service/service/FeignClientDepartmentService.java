package com.microservices.employee_service.service;

import com.microservices.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "DEPARTMENT-SERVICE", url = "http://localhost:8093")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface FeignClientDepartmentService {

    @GetMapping("/api/v1/department/getDepartmentForFeign/{code}")
    DepartmentDto getDepartment(@PathVariable("code") String code);
}
