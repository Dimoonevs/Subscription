package com.example.subscribing.domain.reponse;

import com.example.subscribing.domain.Groups;

public class GetSportsmenByIDResp {
    private String name;
    private String lastName;
    private Long numberWorkouts;
    private Groups group;

    public GetSportsmenByIDResp(String name, String lastName, Long numberWorkouts, Groups group) {
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

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }
}
