package com.example.rwbybackend.repositories;

import com.example.rwbybackend.model.entities.Rail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RailRepo extends JpaRepository<Rail,Long> {

    Optional<Rail> findBySubdivisionNumber(int subdivisionNumber);

    Optional<Rail> findByTrackNumber(int trackNumber);

    Optional<Rail> findByStationOrKm(String stationOrKm);

    Optional<Rail> findByPicketNumber(int picketNumber);

    Optional<Rail> findBySectionNumber(int sectionNumber);

    Optional<Rail> findBySlot(String slot);


}
