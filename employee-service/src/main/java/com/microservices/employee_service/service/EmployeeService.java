package com.microservices.employee_service.service;

import com.microservices.employee_service.dto.EmployeeDto;
import com.microservices.employee_service.dto.EmployeeAndOrganizationWithDepartmentDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeAndOrganizationWithDepartmentDto getEmployeeById(Long id);
}
