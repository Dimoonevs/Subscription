package com.example.subscribing.controller;

import com.example.subscribing.domain.Response;
import com.example.subscribing.service.ForSportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/for/sportsman")
@CrossOrigin(origins = "http://localhost:4200")
public class ForSportsmanController {

    private final ForSportsmanService forSportsmanService;

    @Autowired
    public ForSportsmanController(ForSportsmanService forSportsmanService) {
        this.forSportsmanService = forSportsmanService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<Response> getAllSportsman(){
        return forSportsmanService.getAllSportsman();
    }
    @GetMapping("/get/all/by/grope")
    public ResponseEntity<Response> getAllSportsmanByGrope(@RequestHeader int Grope){
        return forSportsmanService.getAllSportsmanByGrope(Grope);
    }

}
