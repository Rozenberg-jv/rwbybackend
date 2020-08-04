package com.example.rwbybackend.repositories.entities;

import com.example.rwbybackend.model.entities.Rail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface RailRepository extends JpaRepository<Rail, Long> {

    @Query("select r from Rail r where r.subdivisionNumber = ?1 and r.trackNumber = ?2 and " +
            "r.stationOrKm = ?1 and r.picketNumber = ?1 and r.sectionNumber = ?1 and  r.slot like %?1")
    Optional<Rail> findRailByPlace(int subdivisionNumber, int trackNumber, String stationOrKm,
                                   int picketNumber, int sectionNumber, String slot);
}
