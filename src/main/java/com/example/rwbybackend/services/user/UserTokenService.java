package com.example.rwbybackend.services.user;

import com.example.rwbybackend.model.user.TokenType;
import com.example.rwbybackend.model.user.UserToken;
import com.example.rwbybackend.repositories.user.UserTokenRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class UserTokenService {

	@Resource
	private UserTokenRepository userTokenRepository;

	@Transactional
	public UserToken findValidUserTokenByUsernameTypeAndToken(String username, String token, TokenType type) {

		UserToken result = userTokenRepository.findByUsernameAndTokenNotExpired(username, token, type);

		if (result != null && !result.isExpired()) {
			return result;
		}

		return null;
	}

}
