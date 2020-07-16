package com.example.rwbybackend.model.actions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "check_entity")
public class CheckEntity {
    @Id
    @Column(nullable = false)
    private long id;
    @Column(name = "check_date")
    private LocalDate checkDate;
    @Column(name = "work_region")
    private String workRegion;
    @Column(name = "main_track")
    private int mainTrack;
    @Column(name = "io_track")
    private int ioTrack;
    @Column(name = "arrow_track")
    private int arrowTrack;
    @Column(name = "welded_joint")
    private int weldedJoint;
    @Column(name = "connected_track")
    private int connectedTrack;
    @Column(name = "notice_time")
    private LocalDateTime noticeTime;
    @Column(name = "cancel_number")
    private int cancelNumber;
    @Column(name = "cancel_time")
    private LocalDateTime cancelTime;

}
