package com.example.rwbybackend.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Getter
public class EntityPU2b {

    private final LocalDate checkDate;
    private final String responsible;
    private final String defectoscope;

    private final DefectData defect; // вместо коллекции дефектов - один дефект = одна запись в ПУ-2б

    private final int subdivisionNumber;
    private final int trackNumber;
    private final String stationOrKm;
    private final int picketNumber;
    private final int sectionNumber;
    private final String slot;

    private final String factoryMark;
    private final LocalDate factoryYear;
    private final String railType;
    private final long railLength;

    private final String code;

    private final LocalDateTime detectTime;

    private final int noticeNumber;
    private final LocalDateTime noticeTime;

    private final LocalDateTime changeDate;

    private final int cancelNumber;
    private final LocalDateTime cancelTime;



}
