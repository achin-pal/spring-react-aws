package com.demo.basicApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class Controller {

    private ServiceChannel serviceChannel;

    public Controller(ServiceChannel serviceChannel) {
        this.serviceChannel=serviceChannel;
    }

    @GetMapping
    public ResponseEntity<List<Challanges>> getAllChallenges() {
        return new ResponseEntity<>(serviceChannel.getAllChallenges(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addChanllange(@RequestBody Challanges challanges) {
        boolean returnResponse = serviceChannel.addChanllange(challanges);
        if (returnResponse) {
            return new ResponseEntity<>("challanges added successful", HttpStatus.OK);
        } else {
            return  new ResponseEntity<>("challanges not added successful", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{month}")
    public ResponseEntity<Challanges> getChallange(
            @PathVariable String month) {
        Challanges challanges= serviceChannel.getChallange(month);
        if(challanges!=null){
            return  new ResponseEntity<>(challanges, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallange(@PathVariable Long id ,@RequestBody
    Challanges updateChallanges){
      boolean isUpdated = serviceChannel.updateChallange(id , updateChallanges);
        if(isUpdated){
            return  new ResponseEntity<>("challanges updated", HttpStatus.OK);
        }else {
            return  new ResponseEntity<>("challanges Not updated", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallange( @PathVariable Long id){
        boolean isUpdated = serviceChannel.deleteChallange(id);
        if(isUpdated){
            return  new ResponseEntity<>("challanges deleted", HttpStatus.OK);
        }else {
            return  new ResponseEntity<>("challanges Not deleted", HttpStatus.NOT_FOUND);
        }
    }
}