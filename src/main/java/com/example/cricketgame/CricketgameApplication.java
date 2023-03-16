package com.example.cricketgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CricketgameApplication {

	public static void main(String[] args) {
			SpringApplication.run(CricketgameApplication.class, args);
	}

}
