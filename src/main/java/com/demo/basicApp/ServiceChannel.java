package com.demo.basicApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceChannel {

    private Long nextId=1L;
    @Autowired
    ChallangeRepository challangeRepository;
    public ServiceChannel(){}

    public List<Challanges> getAllChallenges(){
        return challangeRepository.findAll();
    }

    public boolean addChanllange( Challanges challanges){
         if (challanges != null){
             challanges.setId(nextId++);
             challangeRepository.save(challanges);
             return true;
         }else {
             return false;
         }
    }

    public Challanges getChallange(String month) {
       Optional<Challanges> challanges=challangeRepository.findByMonthIgnoreCase(month);
        return challanges.orElse(null);
    }

    public boolean updateChallange(Long id, Challanges updateChallanges) {
        Optional<Challanges> challanges=challangeRepository.findById(id);
        if(challanges.isPresent()){
            Challanges challangeToUpdate=challanges.get();
            challangeToUpdate.setMonth(updateChallanges.getMonth());
            challangeToUpdate.setDescription(updateChallanges.getDescription());
            challangeRepository.save(challangeToUpdate);
            return true;
        }
        return false;
    }

    public boolean deleteChallange(Long id) {
        Optional<Challanges> challanges=challangeRepository.findById(id);
        if(challanges.isPresent()) {
            challangeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
