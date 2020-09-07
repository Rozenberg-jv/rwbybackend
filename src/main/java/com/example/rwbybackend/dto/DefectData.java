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

    private final int noticeNumber;
    private final LocalDateTime noticeTime;
    private final int cancelNumber;
    private final LocalDateTime cancelTime;

    private final String placeComment;
    private final String defectGroup;

    private final RailData rail;
}
