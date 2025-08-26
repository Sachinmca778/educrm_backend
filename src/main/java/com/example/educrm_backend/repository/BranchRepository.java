package com.example.educrm_backend.repository;
import com.example.educrm_backend.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    List<Branch> findByInstitute_InstituteId(Long instituteId);
}
