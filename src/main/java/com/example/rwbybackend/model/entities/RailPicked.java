package com.example.rwbybackend.model.entities;

import com.example.rwbybackend.model.ID;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "rail_picked")
public class RailPicked extends ID {

    @Column(name = "out_date")  // дата изъятия
    private LocalDate outDate;

    @Column
    private String kilometer;

    @Column(name = "out_reason")
    private String outReason;  // причина изъятия

    @Column(name = "rail_ref")
    private String railRef;

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

    @OneToOne(fetch = FetchType.EAGER)
    private Rail rail;


    public RailPicked(LocalDate outDate, Rail railInfo, String kilometer, String outReason, String railRef,
                      LocalDate packingDate, String packingPosition, int tonnage, int verticalFretting, int sideFretting,
                      String code, int profilePermille, String profile, String trackPlan, int radius, int rise,
                      String railSlot, String ballastKind, String tieKind, int speed) {
    }
}
