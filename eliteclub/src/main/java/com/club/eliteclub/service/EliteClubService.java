package com.club.eliteclub.service;

import com.club.eliteclub.dao.EliteClubRepository;
import com.club.eliteclub.entity.EliteClub;
import com.club.eliteclub.model.ClubDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EliteClubService {

    @Autowired
    EliteClubRepository eliteClubRepo;

    public List<ClubDTO> getAll(){
        return eliteClubRepo.findAll().stream().map(eliteClub ->
                new ClubDTO(eliteClub.getClubName())).collect(Collectors.toList());
    }

    public void addClub(String... clubNames) {

        Arrays.stream(clubNames).forEach(clubName->{
            EliteClub club = new EliteClub();
            club.setClubName(clubName);
            eliteClubRepo.save(club);
        });
    }
}
