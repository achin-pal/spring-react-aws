package com.demo.basicApp;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceChannel {

    private List<Challanges> allChallanges= new ArrayList<>();
    private Long nextId=1L;

    public ServiceChannel(){}

    public List<Challanges> getAllChallenges(){
        return allChallanges;
    }

    public boolean addChanllange( Challanges challanges){
         if (challanges != null){
             challanges.setId(nextId++);
             allChallanges.add(challanges);
             return true;
         }else {
             return false;
         }
    }

    public Challanges getChallange(String month) {
        for(Challanges challange: allChallanges){
                  if(challange.getMonth().equalsIgnoreCase(month)){
                      return challange;
                  }
        }
        return null;
    }

    public boolean updateChallange(Long id, Challanges updateChallanges) {
        for(Challanges challange: allChallanges){
            if(challange.getId().equals(id)){
                challange.setMonth(updateChallanges.getMonth());
                challange.setDescription(updateChallanges.getDescription());
                return true;
            }
        }
        return false;
    }
}
