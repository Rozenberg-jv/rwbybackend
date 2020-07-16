package com.example.rwbybackend.model.actions;

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
@Table(name = "control_entity")
public class ControlEntity {
    @Id
    @Column(nullable = false)
    private long id;
    @Column
    private int period;
    @Column(name = "registrarion_date")
    private LocalDate registrarionDate;
    @Column(name = "speed")
    private int speed;
    @Column
    private LocalDate date;

}
