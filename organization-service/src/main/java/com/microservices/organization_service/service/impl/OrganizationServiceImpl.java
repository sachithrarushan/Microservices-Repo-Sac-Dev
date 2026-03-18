package com.microservices.organization_service.service.impl;

import com.microservices.organization_service.dto.OrganizationDto;
import com.microservices.organization_service.entity.Organization;
import com.microservices.organization_service.repo.OrganizationRepository;
import com.microservices.organization_service.service.OrganizationService;
import com.microservices.organization_service.utils.mappers.OrganizationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = organizationRepository.save(organizationMapper.DtoToEntity(organizationDto));
        if(organization != null) return organizationMapper.EntityToDto(organization);
        throw new RuntimeException("Organization not saved");
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findOrganizationByOrganizationCode(organizationCode);
        if(organization != null) return organizationMapper.EntityToDto(organization);
        throw new RuntimeException("Organization data not found for given code");
    }
}
