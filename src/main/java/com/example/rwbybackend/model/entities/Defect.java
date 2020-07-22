package com.example.rwbybackend.model.entities;

import com.example.rwbybackend.model.ID;
import com.example.rwbybackend.model.actions.CheckEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "detects")
public class Defect extends ID {

    @Column
    private String code;
    @Column
    private int deep;
    @Column
    private int length;
    @Column(name = "detect_time")
    private LocalDateTime detectTime;
    @Column(name = "notice_number")
    private String noticeNumber;
    @Column
    private String comments;
    @Column(name = "place_comment")
    private String placeComment;
    @Column(name = "defect_group")
    private String defectGroup;

    @ManyToOne
    private Rail rail;

    @ManyToOne
    private CheckEntity checkEntity;
}
