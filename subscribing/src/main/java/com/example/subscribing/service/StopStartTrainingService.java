package com.example.subscribing.service;

import com.example.subscribing.domain.Response;
import org.springframework.http.ResponseEntity;

public interface StopStartTrainingService {
    ResponseEntity<Response> stopExecution();
    ResponseEntity<Response> startExecution();
    ResponseEntity<Response> getExecution();
}
