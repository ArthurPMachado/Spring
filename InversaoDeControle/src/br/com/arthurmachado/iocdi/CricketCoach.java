package br.com.arthurmachado.iocdi;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
	
	public CricketCoach() {
		System.out.println("CricketCoach: Inside no-arg constructor");
	}


	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: Inside setter injection - fortune");
		this.fortuneService = fortuneService;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: Inside setter injection - email");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: Inside setter injection - team");
		this.team = team;
	}

	
}
