package com.example.rwbybackend.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Getter
public class DataPU4 {

    private final LocalDate outDate;
    private final int trackNumber;
    private final String kilometer;
    private final int sectionNumber;
    private final String outReason;
    private final String railType;
    private final int railLength;
    private final String railRef;
    private final String factoryMark;
    private final LocalDate factoryYear;
    private final LocalDate packingDate;
    private final String packingPosition;
    private final int tonnage;
    private final int verticalFretting;
    private final int sideFretting;
    private final String code;
    private final int profilePermille;
    private final String profile;
    private final String trackPlan;
    private final int radius;
    private final int rise;
    private final String railSlot;
    private final String ballastKind;
    private final String tieKind;
    private final int speed;


}
