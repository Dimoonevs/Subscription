package com.example.subscribing.dto.module;

import com.example.subscribing.domain.Groups;
import com.example.subscribing.domain.reponse.SportsmenRespAll;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sportsmen
    implements Comparable<Sportsmen>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private Long numberWorkouts;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupsParam group;

    public Sportsmen() {
    }


    public Sportsmen(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public GroupsParam getGroup() {
        return group;
    }

    public void setGroup(GroupsParam group) {
        this.group = group;
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

    @Override
    public String toString() {
        return "Sportsmen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numberWorkouts=" + numberWorkouts +
                ", group=" + group +
                '}';
    }

    @Override
    public int compareTo(Sportsmen sportsmen) {
        int res = sportsmen.getLastName().compareTo(this.lastName);
        if (res == 0){
            this.name.compareTo(sportsmen.getName());
        }
        return res;
    }
}
