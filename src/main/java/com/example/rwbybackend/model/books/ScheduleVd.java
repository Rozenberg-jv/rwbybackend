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
    @Column(nullable = false)
    private long id;
    @Column
    private LocalDate date;
    @Column(name = "track_title")
    private String trackTitle;
    @Column(name = "last_change")
    private LocalDate lastChange;

}
