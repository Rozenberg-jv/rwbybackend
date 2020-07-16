package com.example.rwbybackend.model.actions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "time_tracking")
public class TimeTracking {
    @Id
    @Column(nullable = false)
    private long id;
    @Column(name = "tracking_date")
    private LocalDate trackingDate;
    @Column(name = "factory_number")
    private String factoryNumber;
    @Column(name = "district_title")
    private String districtTitle;
    @Column(name = "locomotive_request_time")
    private LocalDateTime locomotiveRequestTime;
    @Column(name = "locomotive_time")
    private LocalDateTime locomotiveTime;
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;
    @Column(name = "onway_time")
    private LocalDateTime onwayTime;
    @Column(name = "deadlock_time")
    private LocalDateTime deadlockTime;
    @Column(name = "decoding_start")
    private LocalDateTime decodingStart;
    @Column(name = "decoding_end")
    private LocalDateTime decodingEnd;
    @Column(name = "decoding_time")
    private LocalDateTime decodingTime;
    @Column(name = "night_time")
    private LocalDateTime nightTime;

}
