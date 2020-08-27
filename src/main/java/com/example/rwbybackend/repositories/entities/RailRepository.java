package com.example.rwbybackend.repositories.entities;

import com.example.rwbybackend.model.entities.Rail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;


public interface RailRepository extends JpaRepository<Rail, Long> {

    @Query("select r from Rail r where r.subdivisionNumber = ?1 and r.trackNumber = ?2 and " +
            "r.stationOrKm = ?3 and r.picketNumber = ?4 and r.sectionNumber = ?5 and  r.slot like ?6")
    Optional<Rail> findRailByPlace(int subdivisionNumber, int trackNumber, String stationOrKm,
                                   int picketNumber, int sectionNumber, String slot);

    Optional<Rail> findRailByTrackNumberAndSectionNumberAndRailTypeAndRailLengthAndFactoryMarkAndFactoryYear(int trackNumber,
                                                                                                             int sectionNumber,
                                                                                                             String railType,
                                                                                                             long railLength,
                                                                                                             String factoryMark,
                                                                                                             LocalDate factoryYear);

}
