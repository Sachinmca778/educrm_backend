package com.example.educrm_backend.controller;

import com.example.educrm_backend.dto.*;
import com.example.educrm_backend.service.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educrm/institutes")
@RequiredArgsConstructor
@CrossOrigin
public class InstituteController {

    private final InstituteService instituteservice;

    @GetMapping
    public List<InstituteResponseDTO> getAllInstitutes() {
        return instituteservice.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstituteResponseDTO> getById(@PathVariable Long id) {
        return instituteservice.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InstituteResponseDTO create(@RequestBody InstituteRequestDTO dto) {
        return instituteservice.create(dto);
    }

    @PutMapping("/{id}")
    public InstituteResponseDTO update(@PathVariable Long id, @RequestBody InstituteRequestDTO dto) {
        return instituteservice.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        instituteservice.delete(id);
        return ResponseEntity.noContent().build();
    }
}
