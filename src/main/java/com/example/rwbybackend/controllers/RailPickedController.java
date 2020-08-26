package com.example.rwbybackend.controllers;

import com.example.rwbybackend.controllers.forms.FormPU4;
import com.example.rwbybackend.controllers.forms.SearchForm;
import com.example.rwbybackend.dto.DataPU4;
import com.example.rwbybackend.services.RailPickedService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RailPickedController {

    @NonNull
    private final RailPickedService railPickedService;


    @GetMapping ("/api/picked")
    public ResponseEntity<List<DataPU4>> getPU4Data(@RequestBody @NotNull SearchForm form) {

        List<DataPU4> data = railPickedService.getPU4Data(form);

        return ResponseEntity.ok(data);
    }

    @PostMapping("/api/picked")
    public ResponseEntity<Void> enterPU4Data(@RequestBody FormPU4 form) {

        railPickedService.enterData(form);

        return ResponseEntity.of(Optional.empty());
    }

}
