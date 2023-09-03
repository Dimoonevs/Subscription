package com.example.subscribing.dto.module;

import com.example.subscribing.domain.Groups;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

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

    public Sportsmen(String name,Groups group, String lastName) {
        this.name = name;
        this.lastName = lastName;
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

    public Long setNumberWorkoutsCantingDayTraining() {
        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = currentDate.plusMonths(1);
        Long counting = 0l;
//        System.out.println(currentDate + " " + currentDate.isBefore(endDate));

        while (currentDate.isBefore(endDate)){
            if (currentDate.getDayOfWeek() == DayOfWeek.MONDAY ||
                    currentDate.getDayOfWeek() == DayOfWeek.WEDNESDAY ||
                    currentDate.getDayOfWeek() == DayOfWeek.SATURDAY){
                counting++;
            }
            currentDate = currentDate.plusDays(1);
        }
        return counting;
    }
}
