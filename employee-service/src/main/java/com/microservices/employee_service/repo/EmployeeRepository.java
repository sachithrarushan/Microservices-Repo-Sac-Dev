package com.microservices.employee_service.repo;

import com.microservices.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
