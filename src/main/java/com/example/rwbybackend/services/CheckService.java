package com.example.rwbybackend.services;

import com.example.rwbybackend.controllers.forms.FormPU27;
import com.example.rwbybackend.controllers.forms.SearchForm;
import com.example.rwbybackend.dto.DataPU27;
import com.example.rwbybackend.repositories.CheckEntityRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckService {

    @NonNull
    private final CheckEntityRepository checkEntityRepository;

    public void enterData(FormPU27 form) {
        // new CheckEntity -> persist
        // look for Rail by specified fields (see Rail)
        // new Defect -> persist


    }

    public DataPU27 getPU27Data(SearchForm form) {


    }
}
