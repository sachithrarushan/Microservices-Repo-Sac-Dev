package com.microservices.department_service.repo;

import com.microservices.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByDepartmentCodeEquals(String code);
}
