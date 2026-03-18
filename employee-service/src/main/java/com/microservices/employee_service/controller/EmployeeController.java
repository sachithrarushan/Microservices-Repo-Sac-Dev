package com.microservices.employee_service.controller;

import com.microservices.employee_service.dto.EmployeeDto;
import com.microservices.employee_service.dto.EmployeeAndOrganizationWithDepartmentDto;
import com.microservices.employee_service.service.EmployeeService;
import com.microservices.employee_service.utils.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public ResponseEntity<StandardResponse> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDtoResponse = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Employee saved successfully", employeeDtoResponse
                    ), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/getEmployee/{id}")
    public ResponseEntity<StandardResponse> getEmployeeById(@PathVariable Long id){
        EmployeeAndOrganizationWithDepartmentDto employeeWithDepartmentDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Employee Retrieved Successfully", employeeWithDepartmentDto)
                    , HttpStatus.OK
        );
    }
}
