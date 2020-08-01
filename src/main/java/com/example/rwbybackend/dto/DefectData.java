package com.example.rwbybackend.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class DefectData {

    private final String code;
    private final int deep;
    private final int length;
    private final LocalDateTime detectTime;
    private final String noticeTarget;
    private final String comments;
    private final String placeComment;
    private final String defectGroup;

    private final RailData rail;
}
