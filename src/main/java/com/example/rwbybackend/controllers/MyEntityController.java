package com.example.rwbybackend.controllers;

import com.example.rwbybackend.model.MyEntity;
import com.example.rwbybackend.repositories.MyEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MyEntityController {

    @Autowired
    private final MyEntityRepository myEntityRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
//    @GetMapping(value = "/", produces = "application/json")
    public MyEntity getMyEntity(@RequestParam("id") long id) {

        Optional<MyEntity> byId = myEntityRepository.findById(id);

        return byId.get();
    }
}
