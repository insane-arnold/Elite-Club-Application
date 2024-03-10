package com.club.eliteclub.controller;

import com.club.eliteclub.entity.EliteClub;
import com.club.eliteclub.model.ClubDTO;
import com.club.eliteclub.service.EliteClubService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EliteClubController {

    @Autowired
    EliteClubService clubService;

    @GetMapping(path = "/clubs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClubDTO> getAll(){
        return clubService.getAll();
    }

    @PostMapping("/searchClubsByName")
    public ResponseEntity searchEliteClubsByName(@RequestBody Map<String, String> requestBody) {
        List<ClubDTO> result = clubService.searchByName(requestBody.get("searchTerm"));
        if(!result.isEmpty()) return ResponseEntity.status(HttpStatus.FOUND).body(result);
        else{
            requestBody.put("Error Message", "No Data Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(requestBody);
        }
    }

    @PostMapping(path="createNewClub", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewClub(@RequestBody ClubDTO clubDTO){
        String clubName = clubDTO.getClubName();
        clubService.addClub(clubName);
        return ResponseEntity.status(HttpStatus.CREATED).body(clubDTO);
    }

    @GetMapping(path="getClubById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getClubById(@RequestBody Map<String, Long> request){
        ClubDTO club = clubService.getClubByID(request.get("id"));
        return ResponseEntity.status(HttpStatus.FOUND).body(club);
    }

    @DeleteMapping(path="deleteClubById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteClubById(@RequestBody Map<String, Long> request){
        boolean response = clubService.deleteClubByID(request.get("id"));
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }


    @PutMapping(path="updateClubById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateClubById(@RequestParam Long id, @RequestBody ClubDTO club){
        EliteClub eliteClub = clubService.updateClubById(id, club);
        return ResponseEntity.status(HttpStatus.FOUND).body(eliteClub);
    }
}
