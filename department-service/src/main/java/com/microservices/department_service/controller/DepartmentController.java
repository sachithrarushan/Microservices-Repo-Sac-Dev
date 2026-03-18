package com.microservices.department_service.controller;

import com.microservices.department_service.dto.DepartmentDto;
import com.microservices.department_service.service.DepartmentService;
import com.microservices.department_service.utils.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public ResponseEntity<StandardResponse> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto departmentDtoResponse = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Data saved successfully", departmentDtoResponse)
                        , HttpStatus.CREATED
        );
    }

    @GetMapping("/getDepartment/{code}")
    public ResponseEntity<StandardResponse> getDepartmentByCode(@PathVariable String code){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Data Retrieved Successfully", departmentDto)
                        ,HttpStatus.OK
        );
    }

    @GetMapping("/getDepartmentForFeign/{code}")
    public DepartmentDto getDepartmentByCodeForFeign(@PathVariable String code){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
        return departmentDto;
    }

}
