package com.example.rwbybackend.repositories;

import com.example.rwbybackend.model.entities.Rail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RailRepo extends JpaRepository<Rail,Long> {


    Optional<Rail> findRailByPlace(int subdivision, int trackNumber, String stationOrKm,
                                   int picketNumber, int sectionNumber, String slot);


}
