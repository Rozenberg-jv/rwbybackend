package com.example.rwbybackend.model.actions;

import com.example.rwbybackend.model.ID;
import com.example.rwbybackend.model.books.Defectoscope;
import com.example.rwbybackend.model.books.Responsible;
import com.example.rwbybackend.model.entities.Defect;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "responsible")
@ToString(exclude = "defects")
@Entity
@Table(name = "check_entity")
public class CheckEntity extends ID {

    @Column(name = "check_date")
    private LocalDate checkDate;

    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private Responsible responsible;

    @ManyToOne
    @JoinColumn(name = "defectoscope_id")
    private Defectoscope defectoscope;

    @Column(name = "work_region")
    private String workRegion;
    @Column(name = "main_track")
    private int mainTrack;
    @Column(name = "io_track")
    private int ioTrack;
    @Column(name = "arrow_track")
    private int arrowTrack;
    @Column(name = "welded_joint")
    private int weldedJoint;
    @Column(name = "connected_track")
    private int connectedTrack;
    @Column(name = "notice_time")
    private LocalDateTime noticeTime;
    @Column(name = "cancel_number")
    private int cancelNumber;
    @Column(name = "cancel_time")
    private LocalDateTime cancelTime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detects", fetch = FetchType.EAGER)
    private Set<Defect> defects = new HashSet<>();

    public CheckEntity(LocalDate date, long responsibleId, long defectoscopeId,
                       String workRegion, int mainTrack, int ioTrack, int arrowTrack,
                       int weldedJoint, int connectedTrack) {
    }

}
