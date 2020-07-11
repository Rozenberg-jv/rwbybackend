package com.example.rwbybackend.repositories.user;

import com.example.rwbybackend.model.user.TokenType;
import com.example.rwbybackend.model.user.User;
import com.example.rwbybackend.model.user.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserTokenRepository extends JpaRepository<UserToken, String> {

	@Query("select t from UserToken t where t.user.username = :username and t.token = :token and t.type = :type and t.expires > now()")
	UserToken findByUsernameAndTokenNotExpired(String username, String token, TokenType type);

	List<UserToken> findByUserAndType(User user, TokenType type);
}
