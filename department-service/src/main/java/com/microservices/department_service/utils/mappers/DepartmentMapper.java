package com.microservices.department_service.utils.mappers;

import com.microservices.department_service.dto.DepartmentDto;
import com.microservices.department_service.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department DtoToEntity(DepartmentDto departmentDto);
    DepartmentDto EntityToDto(Department department);
}
