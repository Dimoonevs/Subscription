package com.example.subscribing.service.impl;

import com.example.subscribing.domain.Groups;
import com.example.subscribing.domain.Response;
import com.example.subscribing.domain.exception.Code.Code;
import com.example.subscribing.domain.exception.CommonException;
import com.example.subscribing.domain.reponse.SportsmenRespAll;
import com.example.subscribing.dto.module.GroupsParam;
import com.example.subscribing.dto.module.Sportsmen;
import com.example.subscribing.dto.repository.GroupsRepo;
import com.example.subscribing.dto.repository.SportsmenRepo;
import com.example.subscribing.service.ForSportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ForSportsmanServiceImpl implements ForSportsmanService {
    private final SportsmenRepo sportsmenRepo;
    private final GroupsRepo groupsRepo;

    @Autowired
    public ForSportsmanServiceImpl(SportsmenRepo sportsmenRepo, GroupsRepo groupsRepo) {
        this.sportsmenRepo = sportsmenRepo;
        this.groupsRepo = groupsRepo;
    }

    @Override
    public ResponseEntity<Response> getAllSportsman() {
        List<Sportsmen> sportsman = sportsmenRepo.findAll();
        Collections.sort(sportsman);



        Response response = new Response<>(SportsmenRespAll.sportsmenRewriteToNewObject(sportsman));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> getAllSportsmanByGrope(int grope) {

        if (grope >= 0 && grope < Groups.values().length){
            GroupsParam groupsParam = groupsRepo.getByGroup(Groups.values()[grope]);
            List<Sportsmen> sportsman = sportsmenRepo.findAllByGroup(groupsParam);
            Collections.sort(sportsman);

            Response response = new Response<>(SportsmenRespAll.sportsmenRewriteToNewObject(sportsman));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            throw new CommonException(Code.ENUM_EROR_VALUE, "Такой группы не существует", HttpStatus.BAD_REQUEST);
        }
    }
}
