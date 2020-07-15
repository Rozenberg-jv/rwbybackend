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
@Table(name = "detected_breache")
public class DetectedBreache {
    @Id
    @Column(name = "breache_id", nullable = false)
    private long breacheId;
    @Column(name = "detect_Date")
    private LocalDate detectDate;
    @Column(name = "breache_Type")
    private String breacheType;

}
