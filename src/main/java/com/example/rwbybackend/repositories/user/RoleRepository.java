package com.example.rwbybackend.repositories.user;

import com.example.rwbybackend.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
