package com.example.rwbybackend.model.entities;

import com.example.rwbybackend.model.books.Responsible;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "rails")
public class Rail {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
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
    @Column
    private String slot;
    @Column(name = "track_part")
    private int trackPart;
    @Column(name = "track_title")
    private String trackTitle;
    @Column
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "particulars_id")
    private RailParticulars railParticulars;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fretting_id")
    private RailFretting railFretting;


}
