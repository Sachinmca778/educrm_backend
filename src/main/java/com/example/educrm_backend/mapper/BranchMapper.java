package com.example.educrm_backend.mapper;


import com.example.educrm_backend.dto.BranchResponseDTO;
import com.example.educrm_backend.entity.Branch;

public class BranchMapper {

    public static BranchResponseDTO toDTO(Branch branch) {
        return BranchResponseDTO.builder()
                .branchId(branch.getBranchId())
                .instituteId(branch.getInstitute().getInstituteId())
                .name(branch.getName())
                .address(branch.getAddress())
                .city(branch.getCity())
                .state(branch.getState())
                .contactNumber(branch.getContactNumber())
                .createdAt(branch.getCreatedAt())
                .build();
    }
}