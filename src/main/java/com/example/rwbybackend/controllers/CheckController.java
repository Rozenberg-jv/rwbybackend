package com.example.rwbybackend.controllers;

import com.example.rwbybackend.controllers.forms.FormPU27;
import com.example.rwbybackend.controllers.forms.SearchForm;
import com.example.rwbybackend.dto.DataPU27;
import com.example.rwbybackend.services.CheckService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/api/check")
@RequiredArgsConstructor
public class CheckController {

    @NonNull
    private final CheckService checkService;

    @PostMapping("")
    public ResponseEntity<Void> enterPU27Data(@RequestBody FormPU27 form) {

        checkService.enterData(form);

        return ResponseEntity.of(Optional.empty());
    }

    @GetMapping
    public ResponseEntity<DataPU27> getPU27Data(@RequestBody SearchForm form) {

        DataPU27 data = checkService.getPU27Data(form);

        return ResponseEntity.of(Optional.of(data));
    }
}
