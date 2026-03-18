package com.microservices.organization_service.utils.mappers;

import com.microservices.organization_service.dto.OrganizationDto;
import com.microservices.organization_service.entity.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    Organization DtoToEntity(OrganizationDto organizationDto);
    OrganizationDto EntityToDto(Organization organization);
}
