package com.example.educrm_backend.dto;

import com.example.educrm_backend.entity.SubscriptionPlan;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstituteRequestDTO {
    private String name;
    private String logoUrl;
    private String address;
    private String contactEmail;
    private String contactPhone;
    private SubscriptionPlan subscriptionPlan;
    private Boolean isActive;
}
