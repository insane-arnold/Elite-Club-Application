package com.club.eliteclub.controller;

import com.club.eliteclub.model.ClubDTO;
import com.club.eliteclub.service.EliteClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(path = "/searchClubsByName", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClubDTO> searchEliteClubsByName(@RequestBody Map<String, String> requestBody) {
        return clubService.searchByName(requestBody.get("searchTerm"));
    }
}
