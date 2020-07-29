package br.com.arthurmachado.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AppRestController {

	// Add code for the "/hello" endpoint
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
}
