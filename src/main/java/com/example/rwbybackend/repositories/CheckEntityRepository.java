package com.example.rwbybackend.repositories;

import com.example.rwbybackend.model.actions.CheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface CheckEntityRepository extends JpaRepository<CheckEntity, Long> {

    Optional<CheckEntity> findCheckEntityByCheckDateAndWorkRegion( LocalDate checkDate, String workRegion);
    //стоит уточнить м. ли быть в однц дату и на одном месте работы несколько операторов и сотрудников

    CheckEntity findCheckEntitiesByCheckDate (LocalDate checkDate);

}
