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
@Table(name = "uncontroled_track")
public class UncontroledTrack {
    @Id
    @Column(name = "uncontroled_track_id", nullable = false)
    private long uncontroledTrackId;
    @Column(name = "passage_date")
    private LocalDate passageDate;
    @Column(name = "lengthKM")
    private long lengthKm;
    @Column(name = "reason")
    private String reason;
    @Column(name = "takenAction")
    private String takenAction;

    @ManyToOne
    @JoinColumn(name = "rail_id", referencedColumnName = "rail_id")
    private Rail railByRailId;

}
