package com.example.rwbybackend.model.entities;

import com.example.rwbybackend.model.ID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "rail_fretting")
public class RailFretting extends ID {

    @Column
    private int vertical;
    @Column(name = "active_side")
    private int activeSide;
    @Column(name = "inactive_side")
    private int inactiveSide;
    @Column(name = "crush_clinch")
    private int crushClinch;
    @Column(name = "ripply_fretting")
    private int ripplyFretting;
    @Column(name = "fusing_date")
    private LocalDate fusingDate;
    @Column(name = "polish_date")
    private LocalDate polishDate;
    @Column(name = "polish_kind")
    private LocalDate polishKind;
    @Column(name = "defect_code")
    private long defectCode;
    @Column(name = "clamp_kind")
    private String clampKind;
    @Column(name = "tonnage_before")
    private long tonnageBefore;
    @Column(name = "tonnage_after")
    private long tonnageAfter;

}
