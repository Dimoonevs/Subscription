package com.example.subscribing.controller;

import com.example.subscribing.domain.Response;
import com.example.subscribing.service.StopStartTrainingService;
import com.example.subscribing.service.SubscriptionDaysService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/training")
public class StopStartTrainingController {
    private final StopStartTrainingService service;

    public StopStartTrainingController(StopStartTrainingService service) {
        this.service = service;
    }

    @GetMapping("/stop")
    public ResponseEntity<Response> stop(){
        return service.stopExecution();
    }
    @GetMapping("/start")
    public ResponseEntity<Response> start(){
        return service.startExecution();
    }
    @GetMapping("/get")
    public ResponseEntity<Response> get(){
        return service.getExecution();
    }

}
