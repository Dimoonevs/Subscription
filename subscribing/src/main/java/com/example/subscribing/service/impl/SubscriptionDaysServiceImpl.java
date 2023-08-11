package com.example.subscribing.service.impl;

import com.example.subscribing.dto.module.Sportsmen;
import com.example.subscribing.dto.repository.SportsmenRepo;
import com.example.subscribing.service.SubscriptionDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
public class SubscriptionDaysServiceImpl implements SubscriptionDaysService {
    private final SportsmenRepo sportsmenRepo;
    private static boolean  stopExecution = false;

    @Autowired
    public SubscriptionDaysServiceImpl(SportsmenRepo sportsmenRepo) {
        this.sportsmenRepo = sportsmenRepo;
    }

    @Scheduled(cron = "0 0 20 * * 1,3,6", zone = "Europe/Kiev")
    @Override
    public void performWeeklySubscription() {
        if (stopExecution) {
            System.out.println("Execution is stopped.");
            return;
        }

        List<Sportsmen> sportsman = sportsmenRepo.findAll();

        for (Sportsmen sportsmen:
             sportsman) {
            if (sportsmen.getNumberWorkouts() != 0){
                sportsmen.setNumberWorkouts(sportsmen.getNumberWorkouts() - 1);
                sportsmenRepo.save(sportsmen);
            }
        }
    }


    public static void setStopExecution(boolean stopExecution) {
        SubscriptionDaysServiceImpl.stopExecution = stopExecution;
    }

    public static boolean isStopExecution() {
        return stopExecution;
    }
}
