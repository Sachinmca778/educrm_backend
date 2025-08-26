package com.example.educrm_backend.controller;

import com.example.educrm_backend.dto.BranchRequestDTO;
import com.example.educrm_backend.dto.BranchResponseDTO;
import com.example.educrm_backend.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educrm/branches")
@RequiredArgsConstructor
@CrossOrigin
public class BranchController {

    private final BranchService branchService;

    @PostMapping
    public BranchResponseDTO create(@RequestBody BranchRequestDTO dto) {
        return branchService.createBranch(dto);
    }

    @GetMapping
    public List<BranchResponseDTO> getAll() {
        return branchService.getAllBranches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchResponseDTO> getById(@PathVariable Long id) {
        return branchService.getBranchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/institute/{instituteId}")
    public List<BranchResponseDTO> getByInstituteId(@PathVariable Long instituteId) {
        return branchService.getBranchesByInstituteId(instituteId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }
}