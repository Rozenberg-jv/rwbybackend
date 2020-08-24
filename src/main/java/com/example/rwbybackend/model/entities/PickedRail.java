package com.example.rwbybackend.model.entities;

import com.example.rwbybackend.model.ID;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "picked_rails")
public class PickedRail extends ID {

    @Column(name = "out_date")  // дата изъятия
    private LocalDate outDate;
    @Column(name = "track_number")
    private int trackNumber;
    @Column
    private String kilometer;
    @Column(name = "section_number")
    private int sectionNumber;
    @Column(name = "out_reason")
    private String outReason;  // причина изъятия
    @Column(name = "rail_type")
    private String railType;
    @Column(name = "rail_length")
    private int railLength;
    @Column(name = "rail_ref")
    private String railRef;
    @Column(name = "factory_mark")
    private String factoryMark;
    @Column(name = "factory_year")
    private LocalDate factoryYear;
    @Column(name = "packing_date")
    private LocalDate packingDate;
    @Column(name = "packing_position")
    private String packingPosition;
    @Column
    private int tonnage;
    @Column(name = "vertical_fretting")
    private int verticalFretting;
    @Column(name = "side_fretting")
    private int sideFretting;
    @Column
    private String code;
    @Column(name = "profile_permille")
    private int profilePermille;
    @Column
    private String profile;
    @Column(name = "track_plan")
    private String trackPlan;
    @Column
    private int radius;
    @Column
    private int rise;
    @Column(name = "rail_slot")
    private String railSlot;
    @Column(name = "ballast_kind")
    private String ballastKind;
    @Column(name = "tie_kind")
    private String tieKind;
    @Column
    private int speed;


    public PickedRail(LocalDate outDate, int trackNumber, String kilometer, int sectionNumber, String outReason,
                      String railType, int railLength, String railRef, String factoryMark, LocalDate factoryYear,
                      LocalDate packingDate, String packingPosition, int tonnage, int verticalFretting, int sideFretting,
                      String code, int profilePermille, String profile, String trackPlan, int radius, int rise, String railSlot,
                      String ballastKind, String tieKind, int speed) {
    }
}
