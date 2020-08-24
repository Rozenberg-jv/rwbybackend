package com.example.rwbybackend.repositories.entities;

import com.example.rwbybackend.model.entities.PickedRail;
import com.example.rwbybackend.model.entities.Rail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface PickedRailRepository extends JpaRepository<PickedRail, Long> {

    List<PickedRail> findAllByOutDateBetween(LocalDate from, LocalDate to);

}
