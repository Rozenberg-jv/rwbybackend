package com.example.rwbybackend.services;

import com.example.rwbybackend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    Optional <User> getUserById(Long id);

    void addNewUser(User user);

    void deleteUserById(Long id);

    List<User> getAllUsers();


}
