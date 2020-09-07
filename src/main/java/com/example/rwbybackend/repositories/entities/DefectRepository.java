package com.example.rwbybackend.repositories.entities;

import com.example.rwbybackend.model.entities.Defect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DefectRepository extends JpaRepository <Defect, Long> {

    @Modifying
    @Query(value = "update defects d left join check_entity c on d.check_entity_id=c.id left join rails r on d.rail_id=r.id\n" +
            "set  d.notice_number = ?1 and d.notice_time = ?2 and d.cancel_number = ?3 and d.cancel_time = ?4 \n" +
            "where c.check_date = ?5 and c.responsible_id = ?6 and c.defectoscope_id = ?7 \n" +
            "and r.subdivision_number = ?8 and r.track_number = ?9 and r.station_or_km = ?10 and r.picket_number = ?11\n" +
            "and r.section_number = ?12 and r.slot = ?13;",
           nativeQuery = true)
    void updateDefect(int noticeNumber, LocalDateTime noticeTime, int cancelNumber, LocalDateTime cancelTime,
                      LocalDate checkDate, long responsibleId, long defectoscopeId,
                      int subdivisionNumber, int trackNumber, String stationOrKm, int picketNumber, int sectionNumber, String slot);


}
