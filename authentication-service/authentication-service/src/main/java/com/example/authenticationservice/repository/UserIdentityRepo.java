package com.example.authenticationservice.repository;

import com.example.authenticationservice.entity.UserIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserIdentityRepo extends JpaRepository<UserIdentity, Integer> {
    Optional<UserIdentity> findByName(String username);
}
