package com.example.subscribing.controller;

import com.example.subscribing.domain.Response;
import com.example.subscribing.domain.request.SportsmenReq;
import com.example.subscribing.service.SportsmenService;
import com.example.subscribing.service.SubscriptionDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sportsmen")
public class SportsmenController {

    private final SportsmenService sportsmenService;
    private final SubscriptionDaysService service;
    @Autowired
    public SportsmenController(SportsmenService sportsmenService, SubscriptionDaysService service) {
        this.sportsmenService = sportsmenService;
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Response> addNewSportsmen(@RequestBody SportsmenReq sportsmenReq){
        return sportsmenService.addNewSportsmen(sportsmenReq);
    }
    @PostMapping("/update")
    public ResponseEntity<Response> updateSportsmen(@RequestBody SportsmenReq sportsmenReq,
                                                    @RequestHeader Long id){
        return sportsmenService.updateSportsmen(sportsmenReq, id);
    }
    @GetMapping("/get_by_id")
    public ResponseEntity<Response> getSportsmenByID(@RequestHeader Long id){
        return sportsmenService.getSportsmenByID(id);
    }
    @PostMapping("/freeze")
    public ResponseEntity<Response> freeze(){
        return service.stopExecution();
    }


}
