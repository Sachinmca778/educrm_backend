package com.example.educrm_backend.mapper;

import com.example.educrm_backend.dto.UserResponseDTO;
import com.example.educrm_backend.entity.User;

public class UserMapper {

    public static UserResponseDTO toDTO(User user) {
        return UserResponseDTO.builder()
                .userId(user.getUserId())
                .instituteId(user.getInstitute().getInstituteId())
                .branchId(user.getBranch().getBranchId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole())
                .status(user.getStatus())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
