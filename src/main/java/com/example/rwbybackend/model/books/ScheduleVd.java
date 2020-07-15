package com.example.rwbybackend.model.books;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "schedule_vd")
public class ScheduleVd {
    @Id
    @Column(name = "schedule_vd_id", nullable = false)
    private long scheduleVdId;
    @Column(name = "checked_date")
    private LocalDate checkedDate;
    @Column(name = "track_title")
    private String trackTitle;
    @Column(name = "last_change")
    private LocalDate lastChange;

}
