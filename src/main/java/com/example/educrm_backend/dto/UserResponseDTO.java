package com.example.educrm_backend.dto;

import com.example.educrm_backend.entity.UserRole;
import com.example.educrm_backend.entity.UserStatus;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private Long userId;
    private Long instituteId;
    private Long branchId;
    private String name;
    private String email;
    private String phone;
    private UserRole role;
    private UserStatus status;
    private LocalDateTime createdAt;
}