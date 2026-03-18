package com.microservices.employee_service.utils.mappers;

import com.microservices.employee_service.dto.EmployeeDto;
import com.microservices.employee_service.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee DtoToEntity(EmployeeDto employeeDto);
    EmployeeDto EntityToDto(Employee employee);
}
