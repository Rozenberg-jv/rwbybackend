package com.example.rwbybackend.repositories;

import com.example.rwbybackend.model.actions.CheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CheckEntityRepository extends JpaRepository<CheckEntity, Long> {

    Optional<CheckEntity> findCheckEntityByCheckDateAndWorkRegion(LocalDate checkDate, String workRegion);
    //стоит уточнить м. ли быть в однц дату и на одном месте работы несколько операторов и сотрудников

    List<CheckEntity> findByCheckDateBetween(LocalDate from, LocalDate to);

    @Query(value = "select * from check_entity c left join defects d on c.id=d.check_entity_id where c.check_date" +
            " between ?1 and ?2 and  d.code in ('2%', '3%')",
           nativeQuery = true)
    List<CheckEntity> findCheckEntitiesByCheckDateAndCode (LocalDate from, LocalDate to);

    @Query(value = "select * from check_entity c left join defects d on c.id=d.check_entity_id  left join rails r on d.rail_id=r.id\n" +
            " where check_date  = ?1 and responsible_id = ?2 and defectoscope_id = ?3 and subdivision_number = ?4 " +
            "and track_number = ?5 and station_or_km = ?6 and picket_number = ?7 and section_number = ?8 and slot = ?9" +
            " and code = ?10 and detect_time = ?11",
            nativeQuery = true)
    CheckEntity findPU2b(LocalDate checkDate, long responsibleId, long defectoscopeId, int subdivisionNumber,
                           int trackNumber, String stationOrKm, int picketNumber, int sectionNumber, String slot,
                           String code, LocalDateTime detectTime);

    Optional<CheckEntity> findCheckEntityByCheckDateAndResponsibleAndDefectoscope(LocalDate checkDate, long responsibleId, long defectoscopeId);

}
