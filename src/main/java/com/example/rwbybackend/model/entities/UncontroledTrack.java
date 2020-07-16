package com.example.rwbybackend.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "rail")
@Entity
@Table(name = "uncontroled_track")
public class UncontroledTrack {
    @Id
    @Column(nullable = false)
    private long id;
    @Column(name = "passage_date")
    private LocalDate passageDate;
    @Column(name = "lengthKM")
    private long lengthKm;
    @Column(name = "reason")
    private String reason;
    @Column(name = "takenAction")
    private String takenAction;

    @ManyToOne
    @JoinColumn(name = "rail_id")
    private Rail rail;

}
