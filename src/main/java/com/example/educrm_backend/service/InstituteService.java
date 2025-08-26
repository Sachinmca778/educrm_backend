package com.example.educrm_backend.service;

import com.example.educrm_backend.dto.*;
import com.example.educrm_backend.entity.Institute;
import com.example.educrm_backend.mapper.InstituteMapper;
import com.example.educrm_backend.repository.InstituteRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstituteService {

    private final InstituteRepository repository;

    public List<InstituteResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(InstituteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<InstituteResponseDTO> getById(Long id) {
        return repository.findById(id).map(InstituteMapper::toDTO);
    }

    public InstituteResponseDTO create(InstituteRequestDTO dto) {
        Institute institute = InstituteMapper.toEntity(dto);
        return InstituteMapper.toDTO(repository.save(institute));
    }

    public InstituteResponseDTO update(Long id, InstituteRequestDTO dto) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setLogoUrl(dto.getLogoUrl());
                    existing.setAddress(dto.getAddress());
                    existing.setContactEmail(dto.getContactEmail());
                    existing.setContactPhone(dto.getContactPhone());
                    existing.setSubscriptionPlan(dto.getSubscriptionPlan());
                    existing.setIsActive(dto.getIsActive());
                    return InstituteMapper.toDTO(repository.save(existing));
                })
                .orElseThrow(() -> new RuntimeException("Institute not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
