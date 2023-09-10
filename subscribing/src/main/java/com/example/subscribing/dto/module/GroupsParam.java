package com.example.subscribing.dto.module;

import com.example.subscribing.domain.Groups;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class GroupsParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @Column(name = "grope_workout")
    @Enumerated(EnumType.ORDINAL)
    private Groups group;
    private boolean isFrozen;

    @OneToMany(mappedBy = "group")
    private List<Sportsmen> sportsmen;

    public GroupsParam() {
    }


    public GroupsParam(Groups group) {
        this.group = group;
    }

    public GroupsParam(Groups group, boolean isFrozen) {
        this.group = group;
        this.isFrozen = isFrozen;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }


    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public List<Sportsmen> getSportsmen() {
        return sportsmen;
    }

    public void setSportsmen(List<Sportsmen> sportsmen) {
        this.sportsmen = sportsmen;
    }
    public void addSportsmenToGroupsParam(Sportsmen sportsmen){
        if (this.sportsmen == null){
            this.sportsmen = new ArrayList<>();
        }
        this.sportsmen.add(sportsmen);
        sportsmen.setGroup(this);
    }

    @Override
    public String toString() {
        return "GroupsParam{" +
                "id=" + id +
                ", group=" + group +
                ", isFrozen=" + isFrozen +
                '}';
    }
}
