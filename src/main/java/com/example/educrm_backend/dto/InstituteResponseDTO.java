package com.example.educrm_backend.dto;

import com.example.educrm_backend.entity.SubscriptionPlan;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstituteResponseDTO {
    private Long instituteId;
    private String name;
    private String logoUrl;
    private String address;
    private String contactEmail;
    private String contactPhone;
    private SubscriptionPlan subscriptionPlan;
    private Boolean isActive;
    private LocalDateTime createdAt;
}
