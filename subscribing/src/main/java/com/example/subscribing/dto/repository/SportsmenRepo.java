package com.example.subscribing.dto.repository;

import com.example.subscribing.domain.Groups;
import com.example.subscribing.dto.module.GroupsParam;
import com.example.subscribing.dto.module.Sportsmen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportsmenRepo extends JpaRepository<Sportsmen, Long> {
    boolean existsByNameAndLastName(String name, String lastName);
    List<Sportsmen> findAllByGroup(GroupsParam groups);
}
