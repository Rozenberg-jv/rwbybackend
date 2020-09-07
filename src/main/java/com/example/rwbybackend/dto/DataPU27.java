package com.example.rwbybackend.dto;

import com.example.rwbybackend.model.entities.Defect;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Getter
public class DataPU27 {

    private final LocalDate checkDate;
    private final String responsible;
    private final String defectoscope;

    private final int mainTrack;
    private final int ioTrack;
    private final int arrowTrack;
    private final int weldedJoint;
    private final int connectedTrack;

    private final Set<DefectData> defects;

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
    private final int deep;
    private final int length;



    private final LocalDateTime detectTime;
    private final String noticeTarget;
    private final String comments;
}
