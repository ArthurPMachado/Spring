package br.com.arthurmachado.iocdi;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public CricketCoach() {
		System.out.println("Inside no-arg constructor");
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setter injection");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
