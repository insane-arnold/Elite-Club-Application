package com.club.eliteclub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EliteclubApplication {

	private static Logger logger = LoggerFactory.getLogger(EliteclubApplication.class);
	public static void main(String[] args) {
		logger.info("Starting EliteClubApplication ....");
		SpringApplication.run(EliteclubApplication.class, args);
	}

}
