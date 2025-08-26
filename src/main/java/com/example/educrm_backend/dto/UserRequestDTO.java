package com.example.educrm_backend.dto;

import com.example.educrm_backend.entity.UserRole;
import com.example.educrm_backend.entity.UserStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    private Long instituteId;
    private Long branchId;
    private String name;
    private String email;
    private String phone;
    private String password;
    private UserRole role;
    private UserStatus status;
}
