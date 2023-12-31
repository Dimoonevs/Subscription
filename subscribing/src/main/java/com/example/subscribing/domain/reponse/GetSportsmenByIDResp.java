package com.example.subscribing.domain.reponse;

import com.example.subscribing.domain.Groups;
import com.example.subscribing.dto.module.GroupsParam;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetSportsmenByIDResp {
    private String name;
    private String lastName;
    private Long numberWorkouts;
    @JsonIgnore
    private GroupsParam group;

    public GetSportsmenByIDResp(String name, String lastName, Long numberWorkouts, GroupsParam group) {
        this.name = name;
        this.lastName = lastName;
        this.numberWorkouts = numberWorkouts;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getNumberWorkouts() {
        return numberWorkouts;
    }

    public void setNumberWorkouts(Long numberWorkouts) {
        this.numberWorkouts = numberWorkouts;
    }

    public GroupsParam getGroup() {
        return group;
    }

    public void setGroup(GroupsParam group) {
        this.group = group;
    }
}
