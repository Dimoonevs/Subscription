package com.example.subscribing.service;

import com.example.subscribing.domain.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;

public interface SubscriptionDaysService {
    void performWeeklySubscription();
    ResponseEntity<Response> stopExecution();
}
