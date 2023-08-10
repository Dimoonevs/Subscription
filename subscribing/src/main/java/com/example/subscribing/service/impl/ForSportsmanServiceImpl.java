package com.example.subscribing.service.impl;

import com.example.subscribing.domain.Groups;
import com.example.subscribing.domain.Response;
import com.example.subscribing.domain.exception.Code.Code;
import com.example.subscribing.domain.exception.CommonException;
import com.example.subscribing.dto.module.Sportsmen;
import com.example.subscribing.dto.repository.SportsmenRepo;
import com.example.subscribing.service.ForSportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForSportsmanServiceImpl implements ForSportsmanService {
    private final SportsmenRepo sportsmenRepo;

    @Autowired
    public ForSportsmanServiceImpl(SportsmenRepo sportsmenRepo) {
        this.sportsmenRepo = sportsmenRepo;
    }

    @Override
    public ResponseEntity<Response> getAllSportsman() {
        List<Sportsmen> sportsman = sportsmenRepo.findAll()
                .stream()
                .sorted((sportsmen1, sportsmen2)->Character.compare(sportsmen1.getLastName().charAt(0), sportsmen2.getLastName().charAt(0)))
                .collect(Collectors.toList());

        Response response = new Response<>(sportsman);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> getAllSportsmanByGrope(int grope) {

        if (grope >= 0 && grope < Groups.values().length){
            List<Sportsmen> sportsman = sportsmenRepo.findAllByGroup(Groups.values()[grope])
                    .stream()
                    .sorted((sportsmen1, sportsmen2)->Character.compare(sportsmen1.getLastName().charAt(0), sportsmen2.getLastName().charAt(0)))
                    .collect(Collectors.toList());
            Response response = new Response<>(sportsman);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            throw new CommonException(Code.ENUM_EROR_VALUE, "Такой группы не существует", HttpStatus.BAD_REQUEST);
        }
    }
}
