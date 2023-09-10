package com.example.subscribing.dto.repository;

import com.example.subscribing.domain.Groups;
import com.example.subscribing.dto.module.GroupsParam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupsRepo extends JpaRepository<GroupsParam, Short> {
    List<GroupsParam> getAllByGroup(Groups groups);
    GroupsParam getById(Short id);
    GroupsParam getByGroup(Groups groups);
}
