package com.example.rwbybackend.repositories;

import com.example.rwbybackend.model.users.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
