package com.example.educrm_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "institutes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instituteId;

    @Column(nullable = false)
    private String name;

    private String logoUrl;
    private String address;
    private String contactEmail;
    private String contactPhone;

    @Enumerated(EnumType.STRING)
    private SubscriptionPlan subscriptionPlan;

    private Boolean isActive;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}

