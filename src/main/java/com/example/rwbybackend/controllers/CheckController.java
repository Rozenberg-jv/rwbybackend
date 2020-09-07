package com.example.rwbybackend.controllers;

import com.example.rwbybackend.controllers.forms.FormPU27;
import com.example.rwbybackend.controllers.forms.SearchForm;
import com.example.rwbybackend.dto.DataPU27;
import com.example.rwbybackend.model.user.RoleName;
import com.example.rwbybackend.services.CheckService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController("/api/check")
@RequiredArgsConstructor
public class CheckController {

    @NonNull
    private final CheckService checkService;

    @PostMapping("")
    @Secured(RoleName.DISPETCHER)
    public ResponseEntity<Void> enterPU27Data(@RequestBody FormPU27 form) {

        checkService.enterData(form);

        return ResponseEntity.of(Optional.empty());
    }

    @GetMapping
    @Secured({RoleName.EMPLOEEVD, RoleName.DEFEKTOSKOPIST, RoleName.TEKHNIK, RoleName.DISPETCHER, RoleName.LABORANT, RoleName.GUEST})
    public ResponseEntity<List<DataPU27>> getPU27Data(@RequestBody @NotNull SearchForm form) {

        List<DataPU27> data = checkService.getPU27Data(form);

        return ResponseEntity.ok(data);
    }


}
