package com.example.educrm_backend.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchResponseDTO {
    private Long branchId;
    private Long instituteId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String contactNumber;
    private LocalDateTime createdAt;
}