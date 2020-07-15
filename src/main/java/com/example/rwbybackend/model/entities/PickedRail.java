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
@Table(name = "picked_rail")
public class PickedRail {
    @Id
    @Column(name = "picked_rail_id", nullable = false)
    private long pickedRailId;
    @Column(name = "out_date")
    private LocalDate outDate;
    @Column(name = "railtrack_number")
    private int railtrackNumber;
    @Column(name = "picked_km")
    private int pickedKm;
    @Column(name = "section")
    private long section;
    @Column(name = "takingoutReason")
    private String takingoutReason;
    @Column(name = "rail_type")
    private String railType;
    @Column(name = "rail_length")
    private long railLength;
    @Column(name = "factory_mark")
    private String factoryMark;
    @Column(name = "factory_year")
    private LocalDate factoryYear;
    @Column(name = "packing_date")
    private LocalDate packingDate;
    @Column(name = "position")
    private String position;
    @Column(name = "tonnage")
    private long tonnage;
    @Column(name = "vertical_fretting")
    private int verticalFretting;
    @Column(name = "side_fretting")
    private int sideFretting;
    @Column(name = "defect_code")
    private long defectCode;
    @Column(name = "railtrack_profile1")
    private long railtrackProfile1;
    @Column(name = "railtrack_profile2")
    private String railtrackProfile2;
    @Column(name = "railtrack_plan")
    private String railtrackPlan;
    @Column(name = "radius")
    private long radius;
    @Column(name = "rise")
    private long rise;
    @Column(name = "slot")
    private String slot;
    @Column(name = "ballast")
    private String ballast;
    @Column(name = "tie")
    private String tie;
    @Column(name = "speed")
    private int speed;

}
