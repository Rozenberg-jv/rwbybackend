package com.example.rwbybackend.services;

import com.example.rwbybackend.dto.UserInfoData;
import com.example.rwbybackend.exceptions.InvalidPasswordException;
import com.example.rwbybackend.exceptions.NoSuchEntityException;
import com.example.rwbybackend.model.user.TokenType;
import com.example.rwbybackend.model.user.User;
import com.example.rwbybackend.model.user.UserToken;
import com.example.rwbybackend.repositories.user.UserRepository;
import com.example.rwbybackend.repositories.user.UserTokenRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    @NonNull
    private final UserRepository userRepository;
    @NonNull
    private final UserTokenRepository userTokenRepository;


    public UserInfoData login(String username, String password) {

        Optional<User> optUser = userRepository.findByUsername(username);

        User user = optUser.orElseThrow(() -> new NoSuchEntityException(username));

        if (!user.verifyPassword(password)) {
            throw new InvalidPasswordException(username);
        }

        return UserInfoData.builder()
                .data(generateUserToken(user).getToken())
                .employeeNumber(user.getEmployeeNumber())
                .lastname(user.getLastname())
                .name(user.getName())
                .patronym(user.getPatronym())
                .position(user.getPosition())
                .build();
    }

    protected UserToken generateUserToken(User user) {
        // generating soft token if not exists
        List<UserToken> softTokens = userTokenRepository.findByUserAndType(user, TokenType.SOFT);
        UserToken softToken;
        if (softTokens == null || softTokens.size() == 0) {
            softToken = UserToken.generateSoftUserToken(user);
            softToken = userTokenRepository.saveAndFlush(softToken);
        } else {
            softToken = softTokens.get(0);
            if (softTokens.size() > 1) {
                log.info("user {} has more than one soft token ({}), deleting all others",
                        user.getUsername(),
                        softTokens.size());
                userTokenRepository.deleteAll(softTokens.subList(1, softTokens.size()));
            }

            UserToken hardToken = UserToken.generateHardUserToken(user);
            userTokenRepository.saveAndFlush(hardToken);
        }

        return softToken;
    }
}
