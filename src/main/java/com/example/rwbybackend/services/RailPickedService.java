package com.example.rwbybackend.services;


import com.example.rwbybackend.controllers.forms.FormPU4;
import com.example.rwbybackend.controllers.forms.SearchForm;
import com.example.rwbybackend.dto.DataPU4;
import com.example.rwbybackend.dto.RailData;
import com.example.rwbybackend.model.entities.Rail;
import com.example.rwbybackend.model.entities.RailPicked;
import com.example.rwbybackend.repositories.entities.RailPickedRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RailPickedService {

    // Система должна отображать страницу со списком журналов на выбор (ПУ-2, ПУ-2а, ПУ-2б, ПУ-4) с фильтрами по ПЧ и датой (с-по).

    @NonNull
    private final RailPickedRepository pickedRailRepository;


    public void enterData(FormPU4 form) {
        RailPicked pickedRail = new RailPicked(form.getOutDate(), form.getTrackNumber(), form.getKilometer(),
                form.getSectionNumber(), form.getOutReason(), form.getRailType(), form.getRailLength(),
                form.getRailRef(), form.getFactoryMark(), form.getFactoryYear(), form.getPackingDate(),
                form.getPackingPosition(), form.getTonnage(), form.getVerticalFretting(), form.getSideFretting(),
                form.getCode(), form.getProfilePermille(), form.getProfile(), form.getTrackPlan(), form.getRadius(),
                form.getRise(), form.getRailSlot(), form.getBallastKind(), form.getTieKind(), form.getSpeed());

        pickedRailRepository.saveAndFlush(pickedRail);
    }

    public List<DataPU4> getPU4Data(SearchForm form) {

        List<RailPicked> pickedRails;

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

    private List<DataPU4> renderPickedRails(List<RailPicked> pickedRails) {

        return pickedRails.stream().map(this::renderPickedRail).collect(Collectors.toList());
    }

    private DataPU4 renderPickedRail(RailPicked railPicked) {

        return DataPU4.builder()
                .outDate(railPicked.getOutDate())
                .rail(renderRail(railPicked.getRail()))
                .kilometer(railPicked.getKilometer())
                .outReason(railPicked.getOutReason())
                .railRef(railPicked.getRailRef())
                .packingDate(railPicked.getPackingDate())
                .packingPosition(railPicked.getPackingPosition())
                .tonnage(railPicked.getTonnage())
                .verticalFretting(railPicked.getVerticalFretting())
                .sideFretting(railPicked.getSideFretting())
                .code(railPicked.getCode())
                .profilePermille(railPicked.getProfilePermille())
                .profile(railPicked.getProfile())
                .trackPlan(railPicked.getTrackPlan())
                .radius(railPicked.getRadius())
                .rise(railPicked.getRise())
                .railSlot(railPicked.getRailSlot())
                .ballastKind(railPicked.getBallastKind())
                .tieKind(railPicked.getTieKind())
                .speed(railPicked.getSpeed())
                .build();

    }

    private RailData renderRail(Rail rail) {
        return RailData.builder()
                .trackNumber(rail.getTrackNumber())
                .sectionNumber(rail.getSectionNumber())
                .factoryMark(rail.getFactoryMark())
                .factoryYear(rail.getFactoryYear())
                .railType(rail.getRailType())
                .railLength(rail.getRailLength())
                .build();
    }


}
