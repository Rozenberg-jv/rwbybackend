package com.example.rwbybackend.controllers;

import com.example.rwbybackend.controllers.forms.FormPU2b;
import com.example.rwbybackend.controllers.forms.FormPU4;
import com.example.rwbybackend.controllers.forms.SearchForm;
import com.example.rwbybackend.dto.DataPU2b;
import com.example.rwbybackend.dto.DataPU4;
import com.example.rwbybackend.services.DefectService;
import com.example.rwbybackend.services.util.PickedRailService;
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
public class PickedRailController {

    @NonNull
    private final PickedRailService pickedRailService;


    @GetMapping ("/api/picked")
    public ResponseEntity<List<DataPU4>> getPU4Data(@RequestBody @NotNull SearchForm form) {

        List<DataPU4> data = pickedRailService.getPU4Data(form);

        return ResponseEntity.ok(data);
    }

    @PostMapping("")
    public ResponseEntity<Void> enterPU4Data(@RequestBody FormPU4 form) {

        pickedRailService.enterData(form);

        return ResponseEntity.of(Optional.empty());
    }

}
