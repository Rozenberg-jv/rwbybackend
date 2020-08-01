package com.example.rwbybackend.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Builder
@RequiredArgsConstructor
public class RailData {

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
}
