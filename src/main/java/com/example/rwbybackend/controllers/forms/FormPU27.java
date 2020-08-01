package com.example.rwbybackend.controllers.forms;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormPU27 {

    @NotNull
    private LocalDate checkDate;
    @NotNull
    private long responsibleId;
    @NotNull
    private long defectoscopeId;
    @NotNull
    private String workRegion;
    @NotNull
    private int mainTrack;
    @NotNull
    private int ioTrack;
    @NotNull
    private int arrowTrack;
    @NotNull
    private int weldedJoint;
    @NotNull
    private int connectedTrack;

    private int subdivisionNumber;
    private int trackNumber;
    private String stationOrKm;
    private int picketNumber;
    private int sectionNumber;
    private String slot;

    private String factoryMark;
    private LocalDate factoryYear;
    private String railType;
    private long railLength;

    private String code;
    private int deep;
    private int length;

    private LocalDateTime detectTime;
    private String noticeTarget;
    private String comments;

}
