package br.com.arthurmachado.jackson.json;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// Create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// Read json file and man/convert to Java POJO
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);	
			
			// Print first name and last name
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			
			// Print out address
			Address tempAddress = theStudent.getAddress();
			
			System.out.println("Street = " + tempAddress.getStreet());
			System.out.println("City = " + tempAddress.getCity());
			
			// Print out languages
			for (String item : theStudent.getLanguages()) {
				System.out.println(item);
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
