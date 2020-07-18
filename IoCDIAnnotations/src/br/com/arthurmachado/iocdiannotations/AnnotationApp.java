package br.com.arthurmachado.iocdiannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {

	public static void main(String[] args) {
		
		// Read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get the bean from spring container
		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		
		// Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// Call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// Close the context
		context.close();
	}

}
