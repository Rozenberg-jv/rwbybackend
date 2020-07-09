package com.example.rwbybackend.controllers;

import com.example.rwbybackend.model.User;
import com.example.rwbybackend.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserServiceImpl userServiceImpl;


    @GetMapping(value = "/getById", produces = "application/json")
    public Optional<User> getUserById(@RequestParam("id") long id) {
        return userServiceImpl.getUserById(id);

    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public List<User> getAllUsers() {
        return userServiceImpl.getAllUsers();

    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userServiceImpl.deleteUserById(id);

    }


}
