package com.example.rwbybackend.model.actions;

import com.example.rwbybackend.model.entities.Defect;
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
@Table(name = "natur_control")
public class NaturControl {
    @Id
    @Column(name = "report_id", nullable = false)
    private long reportId;
    @Column(name = "report_date")
    private LocalDate reportDate;
    @Column(name = "taken_action")
    private String takenAction;
    @Column(name = "responsible_person")
    private String responsiblePerson;
    @Column(name = "defektoskopist")
    private String defektoskopist;

    @ManyToOne
    @JoinColumn(name = "defect_id", referencedColumnName = "defect_id")
    private Defect defectByDefectId;

}
