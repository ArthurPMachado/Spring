package br.com.arthurmachado.iocdiannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeApp {

	public static void main(String[] args) {

		// Load Spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from spring container
		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);

		Coach alphaCoach = context.getBean("thatSillyCoach", Coach.class);
		
		// Check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\n Pointing to the same object: " + result);
		
		System.out.println("\n Memory location for theCoach: " + theCoach);
		
		System.out.println("\n Memory location for alphaCoach: " + alphaCoach);
		
		
		// Close the context
		context.close();
	}

}
