package com.example.subscribing.dto.module;

import com.example.subscribing.domain.Groups;
import jakarta.persistence.*;

@Entity
public class Sportsmen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private Long numberWorkouts;
    @Column(name = "grope_workout")
    @Enumerated(EnumType.ORDINAL)
    private Groups group;

    public Sportsmen() {
    }

    public Sportsmen(String name,Groups group, String lastName, Long numberWorkouts) {
        this.name = name;
        this.lastName = lastName;
        this.numberWorkouts = numberWorkouts;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
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
}
