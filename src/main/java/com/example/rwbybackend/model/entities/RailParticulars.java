package com.example.rwbybackend.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "rail_particulars")
public class RailParticulars {
    @Id
    @Column( nullable = false)
    private long id;
    @Column(name = "packing_date")
    private LocalDate packingDate;
    @Column(name = "packing_fature")
    private String packingFature;
    @Column(name = "quality_category")
    private String qualityCategory;
    @Column(name = "rail_kind")
    private String railKind;
    @Column(name = "rail_group")
    private String railGroup;
    @Column
    private String park;
    @Column(name = "from_arrow")
    private int fromArrow;
    @Column(name = "to_arrow")
    private int toArrow;
    @Column(name = "purpose_tra")
    private String purposeTra;
    @Column(name = "track_length_from")
    private long trackLengthFrom;
    @Column(name = "track_length_to")
    private long trackLengthTo;
    @Column(name = "clamp_kind")
    private String clampKind;
    @Column(name = "arrow_number")
    private int arrowNumber;
    @Column(name = "segment_number")
    private int segmentNumber;
    @Column(name = "repair_type")
    private String repairType;
    @Column(name = "validity_group")
    private String validityGroup;
    @Column(name = "measuring_date")
    private LocalDate measuringDate;

}
