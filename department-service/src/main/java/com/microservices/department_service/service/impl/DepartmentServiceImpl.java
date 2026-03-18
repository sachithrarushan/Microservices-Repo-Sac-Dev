package com.microservices.department_service.service.impl;

import com.microservices.department_service.dto.DepartmentDto;
import com.microservices.department_service.entity.Department;
import com.microservices.department_service.repo.DepartmentRepository;
import com.microservices.department_service.service.DepartmentService;
import com.microservices.department_service.utils.mappers.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = departmentRepository.save(departmentMapper.DtoToEntity(departmentDto));
        if(department != null) return departmentMapper.EntityToDto(department);
        throw new RuntimeException("Department save failed");
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findDepartmentByDepartmentCodeEquals(code);
        if(department != null) return departmentMapper.EntityToDto(department);
        throw new RuntimeException("Department not found for given id");
    }
}
