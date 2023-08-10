package com.example.subscribing.dto.repository;

import com.example.subscribing.dto.module.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoachRepo extends JpaRepository<Coach, Long> {
    Optional<Coach> findByLogin(String login);
}
