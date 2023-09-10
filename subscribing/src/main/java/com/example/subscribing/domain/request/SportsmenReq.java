package com.example.subscribing.domain.request;

import com.example.subscribing.domain.Groups;

public class SportsmenReq {
    private String name;
    private String lastName;
    private Long numberWorkouts;
    private Short group;

    public SportsmenReq(String name, String lastName, Long numberWorkouts, Short group) {
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

    public Short getGroup() {
        return group;
    }

    public void setGroup(Short group) {
        this.group = group;
    }
}
