package br.com.arthurmachado.springboot.SpringBootApp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	// Inject properties for: coach.name and team.name
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;

	// Expose new endpoint for "teamInfo"
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: " + this.coachName + ", Team: " + this.teamName;
	}
	
	// Expose "/" that return "Hello World"
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}
}
