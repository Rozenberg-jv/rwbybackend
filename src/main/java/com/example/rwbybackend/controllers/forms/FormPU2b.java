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
public class FormPU2b {

    @NotNull
    private LocalDate checkDate;
    @NotNull
    private long responsibleId;
    @NotNull
    private long defectoscopeId;

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
    private LocalDateTime detectTime;

    private int noticeNumber;
    private LocalDateTime noticeTime;

    private LocalDateTime changeDate;

    private int cancelNumber;
    private LocalDateTime cancelTime;

}
