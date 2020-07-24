package com.example.rwbybackend.repositories.entities;

import com.example.rwbybackend.model.entities.Defect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectRepository extends JpaRepository <Defect, Long> {
}
