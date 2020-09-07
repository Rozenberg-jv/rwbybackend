package com.example.rwbybackend.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormPU4 {    // PickedRail,  для изъятых рельс

    @NotNull
    private LocalDate outDate;
    @NotNull
    private int trackNumber;
    @NotNull
    private String kilometer;
    @NotNull
    private int sectionNumber;
    @NotNull
    private String outReason;
    @NotNull
    private String railType;
    @NotNull
    private long railLength;
    @NotNull
    private String railRef;
    @NotNull
    private String factoryMark;
    @NotNull
    private LocalDate factoryYear;
    private LocalDate packingDate;
    private String packingPosition;
    private int tonnage;
    private int verticalFretting;
    private int sideFretting;
    private String code;
    private int profilePermille;
    private String profile;
    private String trackPlan;
    private int radius;
    private int rise;
    private String railSlot;
    private String ballastKind;
    private String tieKind;
    private int speed;




}
