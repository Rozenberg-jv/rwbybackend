package com.example.rwbybackend.controllers.forms;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
@Builder
public class SearchForm {


    private LocalDate dateFrom;

    private LocalDate dateTo;

}
