package com.example.rwbybackend.services;


import com.example.rwbybackend.controllers.forms.FormPU2b;
import com.example.rwbybackend.controllers.forms.SearchForm;
import com.example.rwbybackend.dto.DataPU2b;
import com.example.rwbybackend.dto.DefectData;
import com.example.rwbybackend.dto.RailData;
import com.example.rwbybackend.model.actions.CheckEntity;
import com.example.rwbybackend.model.entities.Defect;
import com.example.rwbybackend.model.entities.Rail;
import com.example.rwbybackend.repositories.CheckEntityRepository;
import com.example.rwbybackend.repositories.entities.DefectRepository;
import com.example.rwbybackend.repositories.entities.RailRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefectService {

    @NonNull
    private final CheckEntityRepository checkEntityRepository;

    @NonNull
    private final DefectRepository defectRepository;


// Для заполнения ПУ-2б (также и для ПУ-2а):
// Диспетчер ПЧ выбирает из списка дефектов, полученного из отбора в БД результатов ПУ-27, где код дефекта остродефектный,
// (за определенную дату/период) нажимает «Изменить» («Создать» лучше убрать – тогда записи не будут дублироваться или конфликт
// данных проверок) и открывает форму, где графу 1-15  ПУ-2б уже заполнены и дозаполняет графы 16-18 – т.е. поля № и время выдачи
// предупреждения, Время замены, № и время отмены предупреждения. И сохраняет – его пересылает на главную страницу.

    public List<DataPU2b> getPU2bData(SearchForm form) {

        List<CheckEntity> checkEntitiesPU2b;

        if (form.getDateFrom() == null && form.getDateTo() == null) {
            LocalDate now = LocalDate.now();
            int curYear = now.getYear();
            int curMonth = now.getMonthValue();
            checkEntitiesPU2b = checkEntityRepository.findCheckEntitiesByCheckDateAndCode( //выборка еще и по остродеф. коду
                    LocalDate.of(curYear, curMonth, 1),
                    now);
        } else if (form.getDateTo() == null && form.getDateFrom() != null) {
            checkEntitiesPU2b = checkEntityRepository.findCheckEntitiesByCheckDateAndCode(
                    form.getDateFrom(),
                    form.getDateFrom());
        } else {
            checkEntitiesPU2b = checkEntityRepository.findCheckEntitiesByCheckDateAndCode(
                    form.getDateFrom(),
                    form.getDateTo());
        }
        return renderDataPU2b(checkEntitiesPU2b);
    }

    private List<DataPU2b> renderDataPU2b(List<CheckEntity> checkEntities) {
        return checkEntities.stream().map(this::renderCheckEntity).collect(Collectors.toList());
    }

    private DataPU2b renderCheckEntity(CheckEntity check) {
        return DataPU2b.builder()
                .checkDate(check.getCheckDate())
                .responsible(check.getResponsible().getShortName())
                .defectoscope(check.getDefectoscope().getShortName())

                .defects(renderDefects(check.getDefects()))
                .build();
    }

    private Set<DefectData> renderDefects(Set<Defect> defects) {
        return defects.stream().map(this::renderDefect).collect(Collectors.toSet());
    }

    private DefectData renderDefect(Defect defect) {
        return DefectData.builder()
                .code(defect.getCode())
                .detectTime(defect.getDetectTime())
                .noticeNumber(defect.getNoticeNumber())
                .noticeTime(defect.getNoticeTime())
                .cancelNumber(defect.getCancelNumber())
                .cancelTime(defect.getCancelTime())
                .rail(renderRail(defect.getRail()))
                .build();
    }

    private RailData renderRail(Rail rail) {
        return RailData.builder()
                .subdivisionNumber(rail.getSubdivisionNumber())
                .trackNumber(rail.getTrackNumber())
                .stationOrKm(rail.getStationOrKm())
                .picketNumber(rail.getPicketNumber())
                .sectionNumber(rail.getSectionNumber())
                .slot(rail.getSlot())
                .factoryMark(rail.getFactoryMark())
                .factoryYear(rail.getFactoryYear())
                .railType(rail.getRailType())
                .railLength(rail.getRailLength())
                .changeDate(rail.getChangeDate())  // доп.поле пу-2б
                .build();
    }

    public DataPU2b getPU2b(FormPU2b form) {
        CheckEntity check = checkEntityRepository.findPU2b(form.getCheckDate(), form.getResponsibleId(), form.getDefectoscopeId(),
                form.getSubdivisionNumber(), form.getTrackNumber(), form.getStationOrKm(), form.getPicketNumber(),
                form.getSectionNumber(), form.getSlot(), form.getCode(), form.getDetectTime());

        return renderCheckEntity(check);
    }


    public void updateDataPU2b(FormPU2b form) {
        defectRepository.updateDefect(form.getNoticeNumber(), form.getNoticeTime(), form.getCancelNumber(), form.getCancelTime(), //новые данные дефекта
                form.getCheckDate(), form.getResponsibleId(), form.getDefectoscopeId(), // проверка
                form.getSubdivisionNumber(), form.getTrackNumber(), //рельс
                form.getStationOrKm(), form.getPicketNumber(), form.getSectionNumber(), form.getSlot());

    }

}
