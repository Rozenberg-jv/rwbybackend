package com.example.rwbybackend.services;

import com.example.rwbybackend.controllers.forms.FormPU27;
import com.example.rwbybackend.controllers.forms.SearchForm;
import com.example.rwbybackend.dto.DataPU27;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Integer.valueOf;

@Service
@RequiredArgsConstructor
public class CheckService {

    @NonNull
    private final CheckEntityRepository checkEntityRepository;

    @NonNull
    private final RailRepository railRepository;

    @NonNull
    private final DefectRepository defectRepository;

    public void enterData(FormPU27 form) {
        if (form.getCode() != null && !form.getCode().isEmpty()) { //Проверяем есть ли дефект, т.е. начато ли заполнение  9 графы
            Defect defect = new Defect(form.getCode(), form.getDeep(),
                    form.getLength(), form.getDetectTime(),
                    form.getNoticeTarget(), form.getComments(),
                    getRails(form), getCheckEntities(form)); // эти методы ниже отдельно. Проверяем есть ли рельс такой или проверка начата ли
            // и сохраняем новые записи либо достаем имеющиеся в БД для сохранения связи - дефект-рельс-проверка
            defectRepository.save(defect);
        } else {
            // если дефектов нет, то просто сохраняем данные о проверке, не вызывая метода getCheckEntities
            CheckEntity checkEntity = new CheckEntity(form.getCheckDate(), form.getResponsibleId(),
                    form.getDefectoscopeId(), form.getWorkRegion(), form.getMainTrack(), form.getIoTrack(),
                    form.getArrowTrack(), form.getWeldedJoint(), form.getConnectedTrack());
            checkEntityRepository.saveAndFlush(checkEntity);
        }
    }

    public CheckEntity getCheckEntities(FormPU27 form) {
        Optional<CheckEntity> checkEntities = checkEntityRepository
                .findCheckEntityByCheckDateAndWorkRegion(form.getCheckDate(), form.getWorkRegion());
        if (checkEntities.isPresent()) {
            return checkEntities.get();
        } else {
            CheckEntity checkEntity = new CheckEntity(form.getCheckDate(), form.getResponsibleId(),
                    form.getDefectoscopeId(), form.getWorkRegion(), form.getMainTrack(), form.getIoTrack(),
                    form.getArrowTrack(), form.getWeldedJoint(), form.getConnectedTrack());
            checkEntityRepository.saveAndFlush(checkEntity);
            return checkEntity;
        }
    }

    public Rail getRails(FormPU27 form) {
        Optional<Rail> rails = railRepository.findRailByPlace(form.getSubdivisionNumber(), form.getTrackNumber(),
                form.getStationOrKm(), form.getPicketNumber(), form.getSectionNumber(),
                form.getSlot());
        if (rails.isPresent()) {
            return rails.get();
        } else {
            Rail rail = new Rail(form.getSubdivisionNumber(), form.getTrackNumber(),
                    form.getStationOrKm(), form.getPicketNumber(), form.getSectionNumber(),
                    form.getSlot());
            railRepository.saveAndFlush(rail);
            return rail;
        }
    }


    public List<DataPU27> getPU27Data(SearchForm form) {
        /*List<LocalDate> checkDates = new ArrayList<>();
        for (LocalDate i = form.getDateFrom(); i.isAfter(form.getDateTo()); i = i.plusDays(1)) {
            checkDates.add(i);
        }
        List<CheckEntity> checkEntities = new ArrayList<>();
        for (LocalDate d : checkDates) {
            checkEntities.add(checkEntityRepository.findCheckEntitiesByCheckDate(d));
        }*/

        List<CheckEntity> checkEntities;

        if (form.getDateFrom() == null && form.getDateTo() == null) {
            LocalDate now = LocalDate.now();
            int curYear = now.getYear();
            int curMonth = now.getMonthValue();
            checkEntities = checkEntityRepository.findByCheckDateBetween(
                    LocalDate.of(curYear, curMonth, 1),
                    now);
        } else if (form.getDateTo() == null && form.getDateFrom() != null) {
            checkEntities = checkEntityRepository.findByCheckDateBetween(
                    form.getDateFrom(),
                    form.getDateFrom());
        } else {
            checkEntities = checkEntityRepository.findByCheckDateBetween(
                    form.getDateFrom(),
                    form.getDateTo());
        }

        return renderCheckEntities(checkEntities);
    }

    private List<DataPU27> renderCheckEntities(List<CheckEntity> checkEntities) {

        return checkEntities.stream().map(this::renderCheckEntity).collect(Collectors.toList());
    }

    private DataPU27 renderCheckEntity(CheckEntity check) {

        return DataPU27.builder()
                .checkDate(check.getCheckDate())
                .responsible(check.getResponsible().getShortName())
                .defectoscope(check.getDefectoscope().getShortName())
                .mainTrack(check.getMainTrack())
                .ioTrack(check.getIoTrack())
                .arrowTrack(check.getArrowTrack())
                .weldedJoint(check.getWeldedJoint())
                .connectedTrack(check.getConnectedTrack())

                .defects(renderDefects(check.getDefects()))

                .build();
    }

    private Set<DefectData> renderDefects(Set<Defect> defects) {

        return defects.stream().map(this::renderDefect).collect(Collectors.toSet());
    }

    private DefectData renderDefect(Defect defect) {

        return DefectData.builder()
                .code(defect.getCode())
                .deep(defect.getDeep())
                .length(defect.getLength())
                .detectTime(defect.getDetectTime())
                .noticeTarget(defect.getNoticeNumber())
                .comments(defect.getComments())
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
                .build();
    }

}
