package com.example.rwbybackend.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "detects")
public class Defect {
    @Id
    @Column(nullable = false)
    private long id;
    @Column(name = "code")
    private String code;
    @Column(name = "deep")
    private int deep;
    @Column(name = "length")
    private int length;
    @Column(name = "detect_time")
    private LocalDateTime detectTime;
    @Column(name = "notice_number")
    private int noticeNumber;
    @Column(name = "comments")
    private String comments;
    @Column(name = "place_comment")
    private String placeComment;
    @Column(name = "defect_group")
    private String defectGroup;

}
