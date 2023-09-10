package com.example.subscribing.service.impl;

import com.example.subscribing.domain.Groups;
import com.example.subscribing.domain.Response;
import com.example.subscribing.domain.exception.Code.Code;
import com.example.subscribing.domain.exception.CommonException;
import com.example.subscribing.domain.reponse.GroupsFreezedUnfreezedTrainingResp;
import com.example.subscribing.dto.module.GroupsParam;
import com.example.subscribing.dto.repository.GroupsRepo;
import com.example.subscribing.service.StopStartTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopStartTrainingServiceImpl implements StopStartTrainingService {
    @Autowired
    private GroupsRepo groupsRepo;

    @Override
    public ResponseEntity<Response> toggleExecutionGrope(String gropeParams) {
        List<GroupsParam> groups;
        if (gropeParams.equals("ALL")){
             groups = groupsRepo.findAll();
            for (GroupsParam groupsParam:groups){
                groupsParam.setFrozen(!groupsParam.isFrozen());
                groupsRepo.save(groupsParam);
            }
        }else {
            try {
                groups = groupsRepo.getAllByGroup(Groups.valueOf(gropeParams));
                for (GroupsParam groupParam : groups) {
                    groupParam.setFrozen(!groupParam.isFrozen());
                    groupsRepo.save(groupParam);
                }
            }catch (Exception e){
                throw new CommonException(Code.DONT_HAVE_THAT_GROUPE, "Немає такої группи", HttpStatus.BAD_REQUEST);
            }
        }

        Response response = new Response<>("OK");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> getTraining() {
        List<GroupsParam> groupsParams = groupsRepo.findAll();
        GroupsFreezedUnfreezedTrainingResp resp = new GroupsFreezedUnfreezedTrainingResp();

        for (GroupsParam groupsParam : groupsParams){
            if (groupsParam.getGroup() == Groups.LITTLE_GROUP){
                resp.setTrainingIsFreezeLittle(groupsParam.isFrozen());
            }
            if (groupsParam.getGroup() == Groups.BEGINNERS_GROUP){
                resp.setTrainingIsFreezeBeginner(groupsParam.isFrozen());
            }
            if (groupsParam.getGroup() == Groups.OLDER_GROUP){
                resp.setTrainingIsFreezeOlder(groupsParam.isFrozen());
            }
        }
        if (groupsParams.get(0).isFrozen() && groupsParams.get(1).isFrozen() && groupsParams.get(0).isFrozen()){
            resp.setTrainingIsFreezeAll(true);
        }else if (!groupsParams.get(0).isFrozen() && !groupsParams.get(1).isFrozen() && !groupsParams.get(0).isFrozen()){
            resp.setTrainingIsFreezeAll(false);
        }
        Response response = new Response<>(resp);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
