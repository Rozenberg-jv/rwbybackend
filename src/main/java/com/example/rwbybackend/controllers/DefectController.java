package com.example.rwbybackend.controllers;

import com.example.rwbybackend.controllers.forms.FormPU27;
import com.example.rwbybackend.controllers.forms.FormPU2b;
import com.example.rwbybackend.controllers.forms.SearchForm;
import com.example.rwbybackend.dto.DataPU27;
import com.example.rwbybackend.dto.DataPU2b;
import com.example.rwbybackend.services.CheckService;
import com.example.rwbybackend.services.DefectService;
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

@RestController("/api/defect")
@RequiredArgsConstructor
public class DefectController {

    @NonNull
    private final DefectService defectService;


    @GetMapping
    public ResponseEntity<List<DataPU2b>> getPU2bData(@RequestBody @NotNull SearchForm form) {

        List<DataPU2b> data = defectService.getPU2bData(form);

        return ResponseEntity.ok(data);
    }

    @GetMapping
    public ResponseEntity<DataPU2b> getPU2b(@RequestBody FormPU2b form) {

        DataPU2b data = defectService.getPU2b(form);

        return ResponseEntity.ok(data);
    }

    @PostMapping("")
    public ResponseEntity<Void> updatePU27Data(@RequestBody FormPU2b form) {

        defectService.updateDataPU2b(form);

        return ResponseEntity.of(Optional.empty());
    }

}
