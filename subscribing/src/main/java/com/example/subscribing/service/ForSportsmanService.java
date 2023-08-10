package com.example.subscribing.service;

import com.example.subscribing.domain.Response;
import org.springframework.http.ResponseEntity;

public interface ForSportsmanService {
    ResponseEntity<Response> getAllSportsman();

    ResponseEntity<Response> getAllSportsmanByGrope(int grope);
}
