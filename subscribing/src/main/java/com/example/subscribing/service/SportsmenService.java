package com.example.subscribing.service;

import com.example.subscribing.domain.Response;
import com.example.subscribing.domain.request.SportsmenReq;
import org.springframework.http.ResponseEntity;

public interface SportsmenService {
    ResponseEntity<Response> addNewSportsmen(SportsmenReq sportsmenReq);

    ResponseEntity<Response> updateSportsmen(SportsmenReq sportsmenReq, Long id);
    ResponseEntity<Response> getSportsmenByID(Long id);

}
