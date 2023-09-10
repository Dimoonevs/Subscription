package com.example.subscribing.service.impl;

import com.example.subscribing.domain.Groups;
import com.example.subscribing.domain.Response;
import com.example.subscribing.domain.exception.Code.Code;
import com.example.subscribing.domain.exception.CommonException;
import com.example.subscribing.domain.reponse.GetSportsmenByIDResp;
import com.example.subscribing.domain.request.SportsmenReq;
import com.example.subscribing.dto.module.GroupsParam;
import com.example.subscribing.dto.module.Sportsmen;
import com.example.subscribing.dto.repository.GroupsRepo;
import com.example.subscribing.dto.repository.SportsmenRepo;
import com.example.subscribing.service.SportsmenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SportsmenServiceImpl implements SportsmenService {

    private final SportsmenRepo sportsmenRepo;
    public final GroupsRepo groupsRepo;


    public SportsmenServiceImpl(SportsmenRepo sportsmenRepo, GroupsRepo groupsRepo) {
        this.sportsmenRepo = sportsmenRepo;
        this.groupsRepo = groupsRepo;
    }

    @Override
    public ResponseEntity<Response> addNewSportsmen(SportsmenReq sportsmenReq) {
        if (sportsmenRepo.existsByNameAndLastName(sportsmenReq.getName(),sportsmenReq.getLastName())){
            throw new CommonException(Code.SPORTSMEN_IS_EXIST, "Спортсмен уже заведен в базу", HttpStatus.BAD_REQUEST);
        }
        Sportsmen sportsmen = new Sportsmen(sportsmenReq.getName(), sportsmenReq.getLastName());
        Long numberOfWorkOuts = sportsmen.setNumberWorkoutsCantingDayTraining();
        sportsmen.setNumberWorkouts(numberOfWorkOuts);

        GroupsParam groupsParam = groupsRepo.getByGroup(Groups.values()[sportsmenReq.getGroup()]);

        sportsmen.setGroup(groupsParam);
        sportsmenRepo.save(sportsmen);
        Response response = new Response("Спортсмен удачно добавлен в базу");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> updateSportsmen(SportsmenReq sportsmenReq, Long id) {
        Sportsmen sportsmen;
        try {
            sportsmen = sportsmenRepo.findById(id).get();
        }catch (Exception e){
            throw new CommonException(Code.SPORTSMEN_NOT_FOUND, "Сопртсмен не найден в базе данных", HttpStatus.BAD_REQUEST);
        }
        GroupsParam groupsParam = groupsRepo.getByGroup(Groups.values()[sportsmenReq.getGroup()]);
        sportsmen.setName(sportsmenReq.getName());
        sportsmen.setLastName(sportsmenReq.getLastName());
        sportsmen.setGroup(groupsParam);
        if (sportsmen.getNumberWorkouts() != 0) {
            sportsmen.setNumberWorkouts(sportsmenReq.getNumberWorkouts());
        }else {
            sportsmen.setNumberWorkouts(sportsmen.setNumberWorkoutsCantingDayTraining());
        }

        sportsmenRepo.save(sportsmen);

        Response response = new Response<>("Изменения добавились");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> getSportsmenByID(Long id) {
        try {
            Sportsmen sportsmen = sportsmenRepo.findById(id).get();
            Response response = new Response<>(new GetSportsmenByIDResp(sportsmen.getName(), sportsmen.getLastName(), sportsmen.getNumberWorkouts(), sportsmen.getGroup()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            throw new CommonException(Code.SPORTSMEN_IS_EXIST, "Сопртсмен не найден в базе данных", HttpStatus.BAD_REQUEST);
        }
    }
}
