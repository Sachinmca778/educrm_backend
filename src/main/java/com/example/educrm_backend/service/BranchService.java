package com.example.educrm_backend.service;

import com.example.educrm_backend.dto.BranchRequestDTO;
import com.example.educrm_backend.dto.BranchResponseDTO;
import com.example.educrm_backend.entity.Branch;
import com.example.educrm_backend.entity.Institute;
import com.example.educrm_backend.mapper.BranchMapper;
import com.example.educrm_backend.repository.BranchRepository;
import com.example.educrm_backend.repository.InstituteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final InstituteRepository instituteRepository;

    public BranchResponseDTO createBranch(BranchRequestDTO dto) {
        Institute institute = instituteRepository.findById(dto.getInstituteId())
                .orElseThrow(() -> new RuntimeException("Institute not found"));

        Branch branch = Branch.builder()
                .institute(institute)
                .name(dto.getName())
                .address(dto.getAddress())
                .city(dto.getCity())
                .state(dto.getState())
                .contactNumber(dto.getContactNumber())
                .build();

        return BranchMapper.toDTO(branchRepository.save(branch));
    }

    public List<BranchResponseDTO> getAllBranches() {
        return branchRepository.findAll().stream()
                .map(BranchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<BranchResponseDTO> getBranchById(Long id) {
        return branchRepository.findById(id)
                .map(BranchMapper::toDTO);
    }

    public List<BranchResponseDTO> getBranchesByInstituteId(Long instituteId) {
        return branchRepository.findByInstitute_InstituteId(instituteId)
                .stream()
                .map(BranchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }
}