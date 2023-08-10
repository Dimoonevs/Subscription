package com.example.subscribing.controller;

import com.example.subscribing.domain.Response;
import com.example.subscribing.domain.request.CoachLoginReq;
import com.example.subscribing.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coaching")
@CrossOrigin("http://localhost:4200")
public class AuthController {
    private final AuthService adminService;


    @Autowired
    public AuthController(AuthService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody CoachLoginReq coachLoginReq){
        return adminService.login(coachLoginReq);
    }





}
