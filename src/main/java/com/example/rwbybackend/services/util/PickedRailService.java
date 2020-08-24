package com.example.rwbybackend.services.util;


import com.example.rwbybackend.controllers.forms.FormPU4;
import com.example.rwbybackend.controllers.forms.SearchForm;
import com.example.rwbybackend.dto.DataPU4;
import com.example.rwbybackend.model.entities.PickedRail;
import com.example.rwbybackend.repositories.entities.PickedRailRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PickedRailService {

    // Система должна отображать страницу со списком журналов на выбор (ПУ-2, ПУ-2а, ПУ-2б, ПУ-4) с фильтрами по ПЧ и датой (с-по).

    @NonNull
    private final PickedRailRepository pickedRailRepository;


    public void enterData(FormPU4 form) {
        PickedRail pickedRail = new PickedRail(form.getOutDate(), form.getTrackNumber(), form.getKilometer(),
                form.getSectionNumber(), form.getOutReason(), form.getRailType(), form.getRailLength(),
                form.getRailRef(), form.getFactoryMark(), form.getFactoryYear(), form.getPackingDate(),
                form.getPackingPosition(), form.getTonnage(), form.getVerticalFretting(), form.getSideFretting(),
                form.getCode(), form.getProfilePermille(), form.getProfile(), form.getTrackPlan(), form.getRadius(),
                form.getRise(), form.getRailSlot(), form.getBallastKind(), form.getTieKind(), form.getSpeed());

        pickedRailRepository.saveAndFlush(pickedRail);
    }

    public List<DataPU4> getPU4Data(SearchForm form) {

        List<PickedRail> pickedRails;

        if (form.getDateFrom() == null && form.getDateTo() == null) {
            LocalDate now = LocalDate.now();
            int curYear = now.getYear();
            int curMonth = now.getMonthValue();
            pickedRails = pickedRailRepository.findAllByOutDateBetween(
                    LocalDate.of(curYear, curMonth, 1),
                    now);
        } else if (form.getDateTo() == null && form.getDateFrom() != null) {
            pickedRails = pickedRailRepository.findAllByOutDateBetween(
                    form.getDateFrom(),
                    form.getDateFrom());
        } else {
            pickedRails = pickedRailRepository.findAllByOutDateBetween(
                    form.getDateFrom(),
                    form.getDateTo());
        }

        return renderPickedRails(pickedRails);
    }

    private List<DataPU4> renderPickedRails(List<PickedRail> pickedRails) {

        return pickedRails.stream().map(this::renderPickedRail).collect(Collectors.toList());
    }

    private DataPU4 renderPickedRail(PickedRail pickedRail) {

        return DataPU4.builder()
                .outDate(pickedRail.getOutDate())
                .trackNumber(pickedRail.getTrackNumber())
                .kilometer(pickedRail.getKilometer())
                .sectionNumber(pickedRail.getSectionNumber())
                .outReason(pickedRail.getOutReason())
                .railType(pickedRail.getRailType())
                .railLength(pickedRail.getRailLength())
                .railRef(pickedRail.getRailRef())
                .factoryMark(pickedRail.getFactoryMark())
                .factoryYear(pickedRail.getFactoryYear())
                .packingDate(pickedRail.getPackingDate())
                .packingPosition(pickedRail.getPackingPosition())
                .tonnage(pickedRail.getTonnage())
                .verticalFretting(pickedRail.getVerticalFretting())
                .sideFretting(pickedRail.getSideFretting())
                .code(pickedRail.getCode())
                .profilePermille(pickedRail.getProfilePermille())
                .profile(pickedRail.getProfile())
                .trackPlan(pickedRail.getTrackPlan())
                .radius(pickedRail.getRadius())
                .rise(pickedRail.getRise())
                .railSlot(pickedRail.getRailSlot())
                .ballastKind(pickedRail.getBallastKind())
                .tieKind(pickedRail.getTieKind())
                .speed(pickedRail.getSpeed())
                .build();

    }




}
