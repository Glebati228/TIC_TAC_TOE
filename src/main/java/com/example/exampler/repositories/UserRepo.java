package com.example.exampler.repositories;

import com.example.exampler.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>
{
    User findByUsername(String username);

    User findByActivationCode(String code);

    User findByEmail(String email);
}