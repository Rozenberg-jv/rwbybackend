package com.example.rwbybackend.services;

import com.example.rwbybackend.model.users.UserAccount;
import com.example.rwbybackend.repositories.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private final UserAccountRepository userAccountRepository;


    @Override
    public Optional<UserAccount> getUserById(Long id) {
        return userAccountRepository.findById(id);
    }

    @Override
    public void addNewUser(UserAccount userAccount) {
        userAccountRepository.save(userAccount);
    }

    @Override
    public void deleteUserById(Long id) {
        userAccountRepository.deleteById(id);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }
}
