package com.example.rwbybackend.model.entities;

import com.example.rwbybackend.model.ID;
import com.example.rwbybackend.model.actions.CheckEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "detects")
@ToString(exclude = {"rail", "checkEntity"})
public class Defect extends ID {

    @Column
    private String code;
    @Column
    private int deep;
    @Column
    private int length;
    @Column(name = "detect_time")
    private LocalDateTime detectTime;
    @Column(name = "notice_target")
    private String noticeTarget;
    @Column
    private String comments;

    //ПУ-2б
    @Column(name = "notice_number")
    private int noticeNumber;
    @Column(name = "notice_time")
    private LocalDateTime noticeTime;
    @Column(name = "cancel_number")
    private int cancelNumber;
    @Column(name = "cancel_time")
    private LocalDateTime cancelTime;

    @Column(name = "place_comment")
    private String placeComment;
    @Column(name = "defect_group")
    private String defectGroup;

    @ManyToOne(fetch = FetchType.EAGER)
    private Rail rail;

    @ManyToOne
    private CheckEntity checkEntity;


    public Defect(String code, int deep, int length, LocalDateTime detectTime, String noticeNumber,
                  String comments, Rail rail, CheckEntity checkEntity) {
    }

    public Defect(String code, LocalDateTime detectTime, int noticeNumber, LocalDateTime noticeTime,
                  int cancelNumber, LocalDateTime cancelTime, Rail rail, CheckEntity checkEntity) {
    }
}
