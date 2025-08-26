package com.example.educrm_backend.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchRequestDTO {
    private Long instituteId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String contactNumber;
}