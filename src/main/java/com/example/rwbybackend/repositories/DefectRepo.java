package com.example.rwbybackend.repositories;

import com.example.rwbybackend.model.entities.Defect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DefectRepo extends JpaRepository<Defect,Long> {
    Optional<Defect> findByCode(String code);
}
