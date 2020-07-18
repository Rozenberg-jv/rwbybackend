package com.example.rwbybackend.repositories;

import com.example.rwbybackend.model.actions.CheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckEntityRepository extends JpaRepository<CheckEntity, Long> {
}
