package com.example.rwbybackend.controllers.forms;

import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchForm {

    private LocalDate dateFrom;

    private LocalDate dateTo;

}
