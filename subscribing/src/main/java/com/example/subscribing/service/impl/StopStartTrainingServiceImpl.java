package com.example.subscribing.service.impl;

import com.example.subscribing.domain.Response;
import com.example.subscribing.service.StopStartTrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StopStartTrainingServiceImpl implements StopStartTrainingService {
    @Override
    public ResponseEntity<Response> stopExecution() {
        SubscriptionDaysServiceImpl.setStopExecution(true);
        Response response = new Response<>("OK");
        System.out.println("stopExecution = " +  SubscriptionDaysServiceImpl.isStopExecution());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> startExecution() {
        SubscriptionDaysServiceImpl.setStopExecution(false);
        Response response = new Response<>("OK");
        System.out.println("startExecution = " +  SubscriptionDaysServiceImpl.isStopExecution());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> getExecution() {
        Response response = new Response<>(SubscriptionDaysServiceImpl.isStopExecution());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
