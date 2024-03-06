package com.club.eliteclub;

import com.club.eliteclub.model.ClubDTO;
import com.club.eliteclub.service.EliteClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EliteclubApplication implements ApplicationRunner {

	@Autowired
	private EliteClubService eliteClubService;
	private static final Logger logger = LoggerFactory.getLogger(EliteclubApplication.class);
	public static void main(String[] args) {
		logger.info("Starting EliteClubApplication ....");
		SpringApplication.run(EliteclubApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {

		// Code to be executed after the application context is fully loaded
		System.out.println("Executing ApplicationRunner with args: " + args.getOptionNames());
		eliteClubService.addClub("Billionaire", "Environmentalist", "Poker", "Biscep");
		List<ClubDTO> clubList = eliteClubService.searchByName("Bi");
		clubList.forEach(clubDTO -> logger.info("ClubName: {}", clubDTO.getClubName()));
	}

}
