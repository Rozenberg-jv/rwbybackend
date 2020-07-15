package com.example.rwbybackend.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Defect {
    @Id
    @Column(name = "defect_id", nullable = false)
    private long defectId;
    @Column(name = "defect_code")
    private String defectCode;
    @Column(name = "defect_deep")
    private int defectDeep;
    @Column(name = "defect_length")
    private int defectLength;
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
