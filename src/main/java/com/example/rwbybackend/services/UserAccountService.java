package com.example.rwbybackend.services;

import com.example.rwbybackend.model.users.UserAccount;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserAccountService {

    Optional <UserAccount> getUserById(Long id);

    void addNewUser(UserAccount userAccount);

    void deleteUserById(Long id);

    List<UserAccount> getAllUsers();


}
