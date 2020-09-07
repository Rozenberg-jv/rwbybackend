package com.example.rwbybackend.repositories.entities;

import com.example.rwbybackend.model.entities.RailPicked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface RailPickedRepository extends JpaRepository<RailPicked, Long> {

    List<RailPicked> findAllByOutDateBetween(LocalDate from, LocalDate to);

}
