package com.example.educrm_backend.service;

import com.example.educrm_backend.dto.UserRequestDTO;
import com.example.educrm_backend.dto.UserResponseDTO;
import com.example.educrm_backend.entity.Branch;
import com.example.educrm_backend.entity.Institute;
import com.example.educrm_backend.entity.User;
import com.example.educrm_backend.entity.UserStatus;
import com.example.educrm_backend.mapper.UserMapper;
import com.example.educrm_backend.repository.BranchRepository;
import com.example.educrm_backend.repository.InstituteRepository;
import com.example.educrm_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final InstituteRepository instituteRepository;
    private final BranchRepository branchRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserResponseDTO createUser(UserRequestDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Institute institute = instituteRepository.findById(dto.getInstituteId())
                .orElseThrow(() -> new RuntimeException("Institute not found"));

        Branch branch = branchRepository.findById(dto.getBranchId())
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        User user = User.builder()
                .institute(institute)
                .branch(branch)
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .status(dto.getStatus() != null ? dto.getStatus() : UserStatus.ACTIVE)
                .build();

        return UserMapper.toDTO(userRepository.save(user));
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserResponseDTO> getById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDTO);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}