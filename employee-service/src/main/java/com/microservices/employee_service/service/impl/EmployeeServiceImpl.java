package com.microservices.employee_service.service.impl;

import com.microservices.employee_service.dto.DepartmentDto;
import com.microservices.employee_service.dto.EmployeeDto;
import com.microservices.employee_service.dto.EmployeeAndOrganizationWithDepartmentDto;
import com.microservices.employee_service.dto.OrganizationDto;
import com.microservices.employee_service.entity.Employee;
import com.microservices.employee_service.repo.EmployeeRepository;
import com.microservices.employee_service.service.EmployeeService;
import com.microservices.employee_service.utils.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final OrganizationServiceClient organizationServiceClient;
    private final DepartmentServiceClient departmentServiceClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.save(employeeMapper.DtoToEntity(employeeDto));
        if(employee != null) return employeeMapper.EntityToDto(employee);
        throw new RuntimeException("Employee save failed");
    }

    @Override
    public EmployeeAndOrganizationWithDepartmentDto getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        EmployeeDto employeeDto = employeeMapper.EntityToDto(employee);
        DepartmentDto departmentDto = departmentServiceClient.getDepartment(employee.getDepartmentCode());
        OrganizationDto organizationDto = organizationServiceClient.getOrganization(employee.getDepartmentCode());
        return new EmployeeAndOrganizationWithDepartmentDto(
                employeeDto,
                departmentDto,
                organizationDto
        );
    }

}
