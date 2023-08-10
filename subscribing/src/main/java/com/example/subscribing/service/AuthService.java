package com.example.subscribing.service;

import com.example.subscribing.domain.Response;
import com.example.subscribing.domain.request.CoachLoginReq;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<Response> login(CoachLoginReq coachLoginReq);

}
