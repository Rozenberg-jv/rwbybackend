package com.example.rwbybackend.model.entities;

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
@Table(name = "detected_breaches")
public class DetectedBreache {
    @Id
    @Column(nullable = false)
    private long id;
    @Column
    private LocalDate date;
    @Column(name = "breache_Type")
    private String breacheType;

}
