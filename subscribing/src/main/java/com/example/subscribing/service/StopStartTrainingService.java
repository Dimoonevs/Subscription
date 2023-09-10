package com.example.subscribing.service;

import com.example.subscribing.domain.Response;
import com.example.subscribing.domain.request.GropeRequest;
import org.springframework.http.ResponseEntity;

public interface StopStartTrainingService {
    ResponseEntity<Response> toggleExecutionGrope(String gropeParam);

    ResponseEntity<Response> getTraining();
}
