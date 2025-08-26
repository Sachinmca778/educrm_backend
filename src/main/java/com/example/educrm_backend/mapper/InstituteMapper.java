package com.example.educrm_backend.mapper;

import com.example.educrm_backend.dto.*;
import com.example.educrm_backend.entity.Institute;

public class InstituteMapper {

    public static Institute toEntity(InstituteRequestDTO dto) {
        return Institute.builder()
                .name(dto.getName())
                .logoUrl(dto.getLogoUrl())
                .address(dto.getAddress())
                .contactEmail(dto.getContactEmail())
                .contactPhone(dto.getContactPhone())
                .subscriptionPlan(dto.getSubscriptionPlan())
                .isActive(dto.getIsActive() != null ? dto.getIsActive() : true)
                .build();
    }

    public static InstituteResponseDTO toDTO(Institute institute) {
        return InstituteResponseDTO.builder()
                .instituteId(institute.getInstituteId())
                .name(institute.getName())
                .logoUrl(institute.getLogoUrl())
                .address(institute.getAddress())
                .contactEmail(institute.getContactEmail())
                .contactPhone(institute.getContactPhone())
                .subscriptionPlan(institute.getSubscriptionPlan())
                .isActive(institute.getIsActive())
                .createdAt(institute.getCreatedAt())
                .build();
    }
}
