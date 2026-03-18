package com.microservices.organization_service.controller;

import com.microservices.organization_service.dto.OrganizationDto;
import com.microservices.organization_service.service.OrganizationService;
import com.microservices.organization_service.utils.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping("/saveOrganization")
    public ResponseEntity<StandardResponse> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto organizationDtoResponse = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Organization Saved Successfully", organizationDtoResponse),
                    HttpStatus.CREATED
        );
    }

    @GetMapping("/getOrganization/{code}")
    public ResponseEntity<StandardResponse> getOrganization(@PathVariable("code") String organizationCode){
        OrganizationDto organizationDtoResponse = organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Organization data Retrieved successfully", organizationDtoResponse),
                    HttpStatus.OK
        );

    }

    @GetMapping("/getOrganizationForFeign/{code}")
    public OrganizationDto getOrganizationForFeign(@PathVariable("code") String organizationCode){
        OrganizationDto organizationDtoResponse = organizationService.getOrganizationByCode(organizationCode);
        return organizationDtoResponse;
    }

}
