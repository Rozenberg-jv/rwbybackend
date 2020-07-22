package com.example.rwbybackend.model.entities;

import com.example.rwbybackend.model.ID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true,
        of = {"subdivisionNumber", "trackNumber", "stationOrKm", "picketNumber", "slot", "sectionNumber"})
@Entity
@Table(name = "rails")
public class Rail extends ID {

    // unique identifier
    @Column(name = "subdivision_number")
    private int subdivisionNumber;
    @Column(name = "track_number")
    private int trackNumber;
    @Column(name = "station_or_km")
    private String stationOrKm;
    @Column(name = "picket_number")
    private int picketNumber;
    @Column(name = "section_number")
    private int sectionNumber;
    @Column
    private String slot;
    //
    @Column(name = "track_part")
    private int trackPart;
    @Column(name = "track_title")
    private String trackTitle;
    @Column
    private String ferry; // перегон
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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "particulars_id")
    private RailParticulars railParticulars;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fretting_id")
    private RailFretting railFretting;


}
