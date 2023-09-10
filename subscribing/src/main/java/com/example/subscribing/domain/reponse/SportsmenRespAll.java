package com.example.subscribing.domain.reponse;

import com.example.subscribing.dto.module.GroupsParam;
import com.example.subscribing.dto.module.Sportsmen;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class SportsmenRespAll {
    private Long id;
    private String name;
    private String lastName;
    private Long numberWorkouts;
    @JsonIgnore
    private GroupsParam group;

    public SportsmenRespAll(Long id,String name, String lastName, Long numberWorkouts, GroupsParam group) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.numberWorkouts = numberWorkouts;
        this.group = group;
    }
    public static List<SportsmenRespAll> sportsmenRewriteToNewObject(List<Sportsmen> sportsman){
        List<SportsmenRespAll> sportsmenRespAll = new ArrayList<>();
        for (Sportsmen sportsmen: sportsman){
            sportsmenRespAll.add(new SportsmenRespAll(sportsmen.getId(),sportsmen.getName(), sportsmen.getLastName(), sportsmen.getNumberWorkouts(), sportsmen.getGroup()));
        }
        return sportsmenRespAll;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
