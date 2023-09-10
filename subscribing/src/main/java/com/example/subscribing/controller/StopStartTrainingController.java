package com.example.subscribing.controller;

import com.example.subscribing.domain.Response;
import com.example.subscribing.domain.request.GropeRequest;
import com.example.subscribing.service.StopStartTrainingService;
import com.example.subscribing.service.SubscriptionDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/training")
public class StopStartTrainingController {
    private final SubscriptionDaysService subscriptionDaysService;
    private final StopStartTrainingService service;
    @Autowired
    public StopStartTrainingController(SubscriptionDaysService subscriptionDaysService, StopStartTrainingService service) {
        this.subscriptionDaysService = subscriptionDaysService;
        this.service = service;
    }
    @PostMapping("/toggle")
    public ResponseEntity<Response> stop(@RequestBody GropeRequest group){
        return service.toggleExecutionGrope(group.getGrope());
    }
    @GetMapping("/testStart")
    public ResponseEntity<Response> testStart(){
        subscriptionDaysService.performWeeklySubscription();
        return new ResponseEntity<>(new Response<>("OK test stop start"), HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<Response> getTraining(){
        return service.getTraining();
    }


}
