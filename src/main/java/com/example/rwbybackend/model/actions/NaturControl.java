package com.example.rwbybackend.model.actions;

import com.example.rwbybackend.model.entities.Defect;
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
@ToString(exclude = "defect")
@Entity
@Table(name = "natur_control")
public class NaturControl {
    @Id
    @Column(nullable = false)
    private long id;
    @Column
    private LocalDate date;
    @Column(name = "taken_action")
    private String takenAction;
    @Column
    private String responsible;
    @Column
    private String defektoskopist;

    @ManyToOne
    @JoinColumn(name = "defect_id")
    private Defect defect;

}
