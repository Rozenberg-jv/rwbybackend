package com.example.rwbybackend.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Rail {
    @Id
    @Column(name = "rail_id", nullable = false)
    private long railId;
    @Column(name = "subdivision_number")
    private int subdivisionNumber;
    @Column(name = "track_number")
    private int trackNumber;
    @Column(name = "station_or_km")
    private String stationOrKm;
    @Column(name = "picket_number")
    private int picketNumber;
    @Column(name = "section_namber")
    private int sectionNamber;
    @Column(name = "slot")
    private String slot;
    @Column(name = "track_part")
    private int trackPart;
    @Column(name = "track_title")
    private String trackTitle;
    @Column(name = "ferry")
    private String ferry;
    @Column(name = "factory_mark")
    private String factoryMark;
    @Column(name = "factory_year")
    private LocalDate factoryYear;
    @Column(name = "rail_type")
    private String railType;
    @Column(name = "rail_length")
    private long railLength;
    @Column(name = "change_date")
    private LocalDateTime changeDate;

}
