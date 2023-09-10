package com.example.subscribing.service.impl;

import com.example.subscribing.domain.Groups;
import com.example.subscribing.dto.module.GroupsParam;
import com.example.subscribing.dto.module.Sportsmen;
import com.example.subscribing.dto.repository.SportsmenRepo;
import com.example.subscribing.service.SubscriptionDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
public class SubscriptionDaysServiceImpl implements SubscriptionDaysService {
    private final SportsmenRepo sportsmenRepo;

    @Autowired
    public SubscriptionDaysServiceImpl(SportsmenRepo sportsmenRepo) {
        this.sportsmenRepo = sportsmenRepo;
    }

    @Scheduled(cron = "0 0 20 * * 1,3,6", zone = "Europe/Kiev")
    @Override
    public void performWeeklySubscription() {
        List<Sportsmen> sportsmenList = sportsmenRepo.findAll();

        for (Sportsmen sportsmen: sportsmenList){
            System.out.println(sportsmen.getGroup().isFrozen());
            if (!sportsmen.getGroup().isFrozen()){
                System.out.println(sportsmen.getNumberWorkouts() != 0);
                if (sportsmen.getNumberWorkouts() != 0) {
                    sportsmen.setNumberWorkouts(sportsmen.getNumberWorkouts() - 1);
                    sportsmenRepo.save(sportsmen);
                }
            }
        }
    }



}
